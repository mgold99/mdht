/*******************************************************************************
 * Copyright (c) 2010 Sean Muir.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Sean Muir (JKM Software) - initial API and implementation
 *
 * $Id$
 *******************************************************************************/
package org.openhealthtools.mdht.builder.examples;

import java.io.FileOutputStream;

import org.openhealthtools.mdht.builder.ccd.DocumentBuilder.FamilyHistorySectionBuilder;
import org.openhealthtools.mdht.builder.cda.Builder;
import org.openhealthtools.mdht.builder.hitsp.C32DocumentBuilder;
import org.openhealthtools.mdht.builder.hitsp.DocumentBuilder;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Component2;
import org.openhealthtools.mdht.uml.cda.NonXMLBody;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * C32Example is an example implementation of the MDHT
 * DocumentBuilder based on the GOF BuilderPattern. see
 * http://en.wikipedia.org/wiki/Builder_pattern
 * 
 * The DocumentBuilder orchestrates the various CDA Builder components in order
 * to build a complete CDA document. The DocumentBuilder provides default
 * behavior requiring only the need to override the builder you need to created
 * the document while ignoring others.
 * 
 * 
 * This example uses C32DocumentBuilder which creates the minimum structures to create valid (no errors) C32 V2.5
 * 
 */
public class C32FamilyHistoryExample {


	public static void main(String[] args) {

		/*
		 * Define and override various builders
		 */
		DocumentBuilder exampleHITSPC32 = new C32DocumentBuilder() {

			@Override
			public FamilyHistorySectionBuilder getFamilyHistorySectionBuilder() {
				return new FamilyHistorySectionBuilder ()
				{
					
				};
			}

	

		};

		try {
			
			System.out.println(java.util.UUID.randomUUID().toString());
			

			System.out.println("Start");
			ClinicalDocument clinicalDocument = exampleHITSPC32.buildDocument();
			CDAUtil.save(clinicalDocument, new FileOutputStream("/home/eclipse/heliosworkspaceG/org.openhealthtools.mdht.cda.builder/resource/ExampleC32FamilyHistory.xml"));
			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
