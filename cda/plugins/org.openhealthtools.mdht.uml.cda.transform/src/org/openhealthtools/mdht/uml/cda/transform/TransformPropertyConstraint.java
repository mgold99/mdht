/*******************************************************************************
 * Copyright (c) 2009 David A Carlson.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     David A Carlson (XMLmodeling.com) - initial API and implementation
 *     
 * $Id$
 *******************************************************************************/
package org.openhealthtools.mdht.uml.cda.transform;

import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Property;
import org.openhealthtools.mdht.uml.cda.transform.internal.Logger;

/**
 * Transform UML property constraints for: multiplicity, type restriction.
 */
public class TransformPropertyConstraint extends TransformAbstract {

	public TransformPropertyConstraint(EcoreTransformerOptions options) {
		super(options);
	}
	
	public Object caseProperty(Property property) {
		if (isRemoved(property)) {
			return null;
		}
		
		Property cdaProperty = getCDAProperty(property);
		Property inheritedProperty = getInheritedProperty(property);
		if (cdaProperty == null) {
			String message = "Cannot find CDA property for: " + property.getQualifiedName();
			Logger.log(Logger.ERROR, message);
			System.err.println(message);
			return null;
		}
		if (inheritedProperty == null) {
			String message = "Cannot find inherited property for: " + property.getQualifiedName();
			Logger.log(Logger.ERROR, message);
			System.err.println(message);
			return null;
		}

		StringBuffer body = new StringBuffer();
		String selfName = "self." + cdaProperty.getName();
		String templateTypeQName = property.getType().getQualifiedName();
		String inheritedTypeQName = inheritedProperty.getType().getQualifiedName();

		/* 
		 * Test for multiplicity restriction
		 */
		if (property.getLower() != inheritedProperty.getLower()
				|| property.getUpper() != inheritedProperty.getUpper()) {
			
			if (property.getUpper() == 0) {
				// element is prohibited in redefinition
				// place-holder for when this is supported in UML 2.2
			}
			else if (cdaProperty.getUpper() == 1) {
				// single-valued CDA property
				if (property.getLower() == 1) {
					body.append("not " + selfName + ".oclIsUndefined()");
				}
			}
			else if (cdaProperty.getUpper() > 0 
					|| cdaProperty.getUpper() == LiteralUnlimitedNatural.UNLIMITED) {
				// multi-valued CDA property
				if (property.getLower() == 1 && property.getUpper() == 1) {
					body.append(selfName + "->size() = 1");
				}
				else if (property.getLower() >= 1) {
					body.append("not " + selfName + "->isEmpty()");
				}
			}
		}
		
		/*
		 * Test for type restriction
		 */
		if (!templateTypeQName.equals(inheritedTypeQName)) {
			if (body.length() > 0) {
				body.append(" and ");
			}
			
			if (cdaProperty.getUpper() == 1) {
				body.append(selfName + ".oclIsTypeOf(" + templateTypeQName + ")");
			}
			else {
				body.append(selfName + "->forAll(element | element.oclIsTypeOf(" + templateTypeQName + "))");
			}
		}
		
		if (body.length() > 0) {
			addOCLConstraint(property, body);
		}
		
		// test for redefinition
		// else remove the property
		removeModelElement(property);
		
		return property;
	}

}
