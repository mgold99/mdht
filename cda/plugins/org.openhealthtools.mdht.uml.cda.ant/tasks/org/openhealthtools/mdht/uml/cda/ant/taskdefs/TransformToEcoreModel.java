/*******************************************************************************
 * Copyright (c) 2009, 2011 David A Carlson and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     David A Carlson (XMLmodeling.com) - initial API and implementation
 *     Kenn Hussey - adjusted to handle containment proxies
 *     Kenn Hussey - adjusted to handle (model) properties files
 *     
 * $Id$
 *******************************************************************************/
package org.openhealthtools.mdht.uml.cda.ant.taskdefs;


import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Package;
import org.openhealthtools.mdht.uml.cda.transform.EcoreTransformer;
import org.openhealthtools.mdht.uml.cda.transform.EcoreTransformerOptions;
import org.openhealthtools.mdht.uml.common.util.UMLUtil;

/** Transform CDA conceptual model to UML with Ecore extensions.
 *
 * @version $Id: $
 */
public class TransformToEcoreModel extends CDAModelingSubTask {

    /* attributes of this Ant task */
	private String ecoreModelPath = null;
	private Boolean generateDomainInterface = null;
	private Boolean includeFixedValueGetters = null;
	private Boolean includeInterfaceRealization = null;

	/* child elements of this Ant task */
//	private List<ModelElement> elements = new ArrayList<ModelElement>();
	
    public TransformToEcoreModel(CDAModelingTask parentTask) {
    	super(parentTask);
    }

	protected void checkAttributes() throws BuildException {
		assertTrue("The 'model' attribute must be specified.",
				getHL7ModelingTask().getDefaultModel() != null);
	}

    private void initializeProperties() {
    	Project project = getProject();

    	if (ecoreModelPath == null && project.getProperty("ecoreModel") != null) {
    		ecoreModelPath = project.getProperty("ecoreModel");
    	}
    	if (generateDomainInterface == null && project.getProperty("generateDomainInterface") != null) {
    		generateDomainInterface = Boolean.valueOf(project.getProperty("generateDomainInterface"));
    	}
    	if (includeFixedValueGetters == null && project.getProperty("includeFixedValueGetters") != null) {
    		includeFixedValueGetters = Boolean.valueOf(project.getProperty("includeFixedValueGetters"));
    	}
    	if (includeInterfaceRealization == null && project.getProperty("includeInterfaceRealization") != null) {
    		includeInterfaceRealization = Boolean.valueOf(project.getProperty("includeInterfaceRealization"));
    	}

    }
    
    public void doExecute() throws Exception {
    	// initial values from Ant global project properties
    	initializeProperties();
    	
		IProgressMonitor monitor = getProgressMonitor();
		transformToUML(monitor);
    }

    private void transformToUML(IProgressMonitor monitor) {
    	Package umlModel = getHL7ModelingTask().getDefaultModel();
    	Resource umlResource = umlModel.eResource();

    	URI propertiesURI = UMLUtil.getPropertiesURI(umlResource);
    	String properties = UMLUtil.readProperties(propertiesURI);
    	Map<String, String> parsedProperties = properties != null ? UMLUtil.parseProperties(properties) : new LinkedHashMap<String, String>();
    	
    	EcoreUtil.resolveAll(umlResource.getResourceSet());

		EList<EObject> umlResourceContents = umlResource.getContents();

		for (Resource controlledResource : UMLUtil.getControlledResources(umlResource)) {
	    	URI controlledPropertiesURI = UMLUtil.getPropertiesURI(controlledResource);
	    	String controlledProperties = UMLUtil.readProperties(controlledPropertiesURI);
	    	
	    	if (controlledProperties != null) {
	    		parsedProperties.putAll(UMLUtil.parseProperties(controlledProperties));
	    	}

			for (ListIterator<EObject> contents = controlledResource.getContents().listIterator(); contents.hasNext(); ) {
				EObject next = contents.next();
				
				contents.remove();

				if (next.eContainer() == null) {
					umlResourceContents.add(next);
				}
			}
		}

		URI ecoreModelURI = null;
		if (ecoreModelPath != null) {
			ecoreModelURI = URI.createFileURI(ecoreModelPath);
		}
		if (ecoreModelURI == null) {
			ecoreModelURI = umlResource.getURI();
			ecoreModelURI = ecoreModelURI.trimFileExtension();
			ecoreModelURI = ecoreModelURI.trimSegments(1).appendSegment(ecoreModelURI.lastSegment() + "_Ecore");
		}

		String fileExtension = umlResource.getURI().fileExtension();
		if (!fileExtension.equals(ecoreModelURI.fileExtension())) {
			ecoreModelURI = ecoreModelURI.appendFileExtension(fileExtension);
		}
		
		umlResource.setURI(ecoreModelURI);
		
    	EcoreTransformerOptions options = new EcoreTransformerOptions();
    	if (generateDomainInterface != null) {
    		options.setGenerateDomainInterface(generateDomainInterface);
    	}
    	if (includeFixedValueGetters != null) {
    		options.setIncludeFixedValueGetters(includeFixedValueGetters);
    	}
    	if (includeInterfaceRealization != null) {
    		options.setIncludeInterfaceRealization(includeInterfaceRealization);
    	}

    	EcoreTransformer transformer = new EcoreTransformer(options);
    	transformer.transformElement(umlModel);
    	
		monitor.worked(1);
		if( monitor.isCanceled() )
			return;
		
		/* Save */
		monitor.setTaskName("Saving model");

		logInfo("Saving model: " + ecoreModelURI.toString());
		
		try {
			Map<String, String> saveOptions = new HashMap<String, String>();
			umlResource.save(saveOptions);
			
			if (!parsedProperties.isEmpty()) {
				UMLUtil.writeProperties(UMLUtil.getPropertiesURI(umlResource), parsedProperties);				
			}
		} catch (IOException e) {
			throw new BuildException(e);
		}
    }
    
    
    // ANT task attributes -----------------------------------------------------

	public void setEcoreModel(String path) {
		ecoreModelPath = path;
	}

	public void setGenerateDomainInterface(boolean include) {
		generateDomainInterface = new Boolean(include);
	}

	public void setIncludeFixedValueGetters(boolean include) {
		includeFixedValueGetters = new Boolean(include);
	}

	public void setIncludeInterfaceRealization(boolean include) {
		includeInterfaceRealization = new Boolean(include);
	}


	// ANT task child elements
	// --------------------------------------------------
	
    
}
