/**
 * Copyright (c) 2010 IBM Corporation
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *
 * $Id$
 */
package org.openhealthtools.mdht.uml.hl7.rim.operations;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This class represents a suite of JUnit 4 test cases for IHE document
 * processing.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( {
	ActOperationsTest.class,
	ActRelationshipOperationsTest.class,
	EntityOperationsTest.class,
	InfrastructureRootOperationsTest.class,
	ParticipationOperationsTest.class,
	RoleLinkOperationsTest.class,
	RoleOperationsTest.class
})

public class AllRIMOperationsTests {
	// Nothing
} // AllRIMOperationsTests