/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.openhealthtools.mdht.uml.cda.consol.tests;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.StrucDocText;
import org.openhealthtools.mdht.uml.cda.consol.ConsolFactory;
import org.openhealthtools.mdht.uml.cda.consol.ImmunizationsSection;
import org.openhealthtools.mdht.uml.cda.consol.operations.ImmunizationsSectionOperations;
import org.openhealthtools.mdht.uml.cda.operations.CDAValidationTest;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Immunizations Section</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.openhealthtools.mdht.uml.cda.consol.ImmunizationsSection#validateImmunizationsSectionHasMedicationOrSupplyActivity(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Immunizations Section Has Medication Or Supply Activity</em>}</li>
 *   <li>{@link org.openhealthtools.mdht.uml.cda.consol.ImmunizationsSection#validateImmunizationsSectionEntriesOptionalCode(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Immunizations Section Entries Optional Code</em>}</li>
 *   <li>{@link org.openhealthtools.mdht.uml.cda.consol.ImmunizationsSection#validateImmunizationsSectionTitle(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Immunizations Section Title</em>}</li>
 *   <li>{@link org.openhealthtools.mdht.uml.cda.consol.ImmunizationsSection#validateImmunizationsSectionText(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Immunizations Section Text</em>}</li>
 *   <li>{@link org.openhealthtools.mdht.uml.cda.consol.ImmunizationsSection#validateImmunizationsSectionImmunization(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Immunizations Section Immunization</em>}</li>
 *   <li>{@link org.openhealthtools.mdht.uml.cda.consol.ImmunizationsSection#getnullImmunizations() <em>Getnull Immunizations</em>}</li>
 *   <li>{@link org.openhealthtools.mdht.uml.cda.consol.ImmunizationsSection#validateImmunizationsSectionEntriesOptionalTemplateId(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Immunizations Section Entries Optional Template Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */

public class ImmunizationsSectionTest extends CDAValidationTest {

	/**
	*
	* @generated
	*/
	@Test
	public void testValidateImmunizationsSectionHasMedicationOrSupplyActivity() {
		OperationsTestCase<ImmunizationsSection> validateImmunizationsSectionHasMedicationOrSupplyActivityTestCase = new OperationsTestCase<ImmunizationsSection>(
			"validateImmunizationsSectionHasMedicationOrSupplyActivity",
			operationsForOCL.getOCLValue("VALIDATE_IMMUNIZATIONS_SECTION_HAS_MEDICATION_OR_SUPPLY_ACTIVITY__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP"),
			objectFactory) {

			@Override
			protected void updateToFail(ImmunizationsSection target) {

			}

			@Override
			protected void updateToPass(ImmunizationsSection target) {
				target.init();

			}

			@Override
			protected boolean validate(EObject objectToTest, BasicDiagnostic diagnostician, Map<Object, Object> map) {

				return ImmunizationsSectionOperations.validateImmunizationsSectionHasMedicationOrSupplyActivity(
					(ImmunizationsSection) objectToTest, diagnostician, map);
			}

		};

		validateImmunizationsSectionHasMedicationOrSupplyActivityTestCase.doValidationTest();
	}

	/**
	*
	* @generated
	*/
	@Test
	public void testValidateImmunizationsSectionEntriesOptionalCode() {
		OperationsTestCase<ImmunizationsSection> validateImmunizationsSectionEntriesOptionalCodeTestCase = new OperationsTestCase<ImmunizationsSection>(
			"validateImmunizationsSectionEntriesOptionalCode",
			operationsForOCL.getOCLValue("VALIDATE_IMMUNIZATIONS_SECTION_ENTRIES_OPTIONAL_CODE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP"),
			objectFactory) {

			@Override
			protected void updateToFail(ImmunizationsSection target) {

			}

			@Override
			protected void updateToPass(ImmunizationsSection target) {
				target.init();

			}

			@Override
			protected boolean validate(EObject objectToTest, BasicDiagnostic diagnostician, Map<Object, Object> map) {

				return ImmunizationsSectionOperations.validateImmunizationsSectionEntriesOptionalCode(
					(ImmunizationsSection) objectToTest, diagnostician, map);
			}

		};

		validateImmunizationsSectionEntriesOptionalCodeTestCase.doValidationTest();
	}

	/**
	*
	* @generated
	*/
	@Test
	public void testValidateImmunizationsSectionTitle() {
		OperationsTestCase<ImmunizationsSection> validateImmunizationsSectionTitleTestCase = new OperationsTestCase<ImmunizationsSection>(
			"validateImmunizationsSectionTitle",
			operationsForOCL.getOCLValue("VALIDATE_IMMUNIZATIONS_SECTION_TITLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP"),
			objectFactory) {

			@Override
			protected void updateToFail(ImmunizationsSection target) {

			}

			@Override
			protected void updateToPass(ImmunizationsSection target) {
				target.init();

				ST title = DatatypesFactory.eINSTANCE.createST("title");
				target.setTitle(title);

			}

			@Override
			protected boolean validate(EObject objectToTest, BasicDiagnostic diagnostician, Map<Object, Object> map) {

				return ImmunizationsSectionOperations.validateImmunizationsSectionTitle(
					(ImmunizationsSection) objectToTest, diagnostician, map);
			}

		};

		validateImmunizationsSectionTitleTestCase.doValidationTest();
	}

	/**
	*
	* @generated
	*/
	@Test
	public void testValidateImmunizationsSectionText() {
		OperationsTestCase<ImmunizationsSection> validateImmunizationsSectionTextTestCase = new OperationsTestCase<ImmunizationsSection>(
			"validateImmunizationsSectionText",
			operationsForOCL.getOCLValue("VALIDATE_IMMUNIZATIONS_SECTION_TEXT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP"),
			objectFactory) {

			@Override
			protected void updateToFail(ImmunizationsSection target) {

			}

			@Override
			protected void updateToPass(ImmunizationsSection target) {
				target.init();

				StrucDocText text = CDAFactory.eINSTANCE.createStrucDocText();
				target.setText(text);

			}

			@Override
			protected boolean validate(EObject objectToTest, BasicDiagnostic diagnostician, Map<Object, Object> map) {

				return ImmunizationsSectionOperations.validateImmunizationsSectionText(
					(ImmunizationsSection) objectToTest, diagnostician, map);
			}

		};

		validateImmunizationsSectionTextTestCase.doValidationTest();
	}

	/**
	*
	* @generated
	*/
	@Test
	public void testValidateImmunizationsSectionImmunization() {
		OperationsTestCase<ImmunizationsSection> validateImmunizationsSectionImmunizationTestCase = new OperationsTestCase<ImmunizationsSection>(
			"validateImmunizationsSectionImmunization",
			operationsForOCL.getOCLValue("VALIDATE_IMMUNIZATIONS_SECTION_IMMUNIZATION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP"),
			objectFactory) {

			@Override
			protected void updateToFail(ImmunizationsSection target) {

			}

			@Override
			protected void updateToPass(ImmunizationsSection target) {
				target.init();

			}

			@Override
			protected boolean validate(EObject objectToTest, BasicDiagnostic diagnostician, Map<Object, Object> map) {

				return ImmunizationsSectionOperations.validateImmunizationsSectionImmunization(
					(ImmunizationsSection) objectToTest, diagnostician, map);
			}

		};

		validateImmunizationsSectionImmunizationTestCase.doValidationTest();
	}

	/**
	*
	* @generated
	*/
	@Test
	public void testGetnullImmunizations() {

		ImmunizationsSection target = objectFactory.create();
		target.getnullImmunizations();

	}

	/**
	*
	* @generated
	*/
	@Test
	public void testValidateImmunizationsSectionEntriesOptionalTemplateId() {
		OperationsTestCase<ImmunizationsSection> validateImmunizationsSectionEntriesOptionalTemplateIdTestCase = new OperationsTestCase<ImmunizationsSection>(
			"validateImmunizationsSectionEntriesOptionalTemplateId",
			operationsForOCL.getOCLValue("VALIDATE_IMMUNIZATIONS_SECTION_ENTRIES_OPTIONAL_TEMPLATE_ID__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP"),
			objectFactory) {

			@Override
			protected void updateToFail(ImmunizationsSection target) {

			}

			@Override
			protected void updateToPass(ImmunizationsSection target) {
				target.init();

			}

			@Override
			protected boolean validate(EObject objectToTest, BasicDiagnostic diagnostician, Map<Object, Object> map) {

				return ImmunizationsSectionOperations.validateImmunizationsSectionEntriesOptionalTemplateId(
					(ImmunizationsSection) objectToTest, diagnostician, map);
			}

		};

		validateImmunizationsSectionEntriesOptionalTemplateIdTestCase.doValidationTest();
	}

	/**
	*
	* @generated
	*/
	private static class OperationsForOCL extends ImmunizationsSectionOperations {
		public String getOCLValue(String fieldName) {

			String oclValue = null;

			try {
				oclValue = (String) this.getClass().getSuperclass().getDeclaredField(fieldName).get(this);
			} catch (Exception e) {
				oclValue = "NO OCL FOUND FOR PROPERTY " + fieldName;
			}
			return oclValue;
		}
	}

	/**
	*
	* @generated
	*/
	private static class ObjectFactory implements TestObjectFactory<ImmunizationsSection> {

		public ImmunizationsSection create() {
			return ConsolFactory.eINSTANCE.createImmunizationsSection();
		}
	}

	/**
	*
	* @generated
	*/
	private static OperationsForOCL operationsForOCL = new OperationsForOCL();

	/**
	*
	* @generated
	*/
	private static ObjectFactory objectFactory = new ObjectFactory();

	/**
	* Tests Operations Constructor for 100% coverage
	* @generated
	*/
	private static class ConstructorTestClass extends ImmunizationsSectionOperations {
	};

	/**
	* Tests Operations Constructor for 100% coverage
	* @generated
	*/
	@Test
	public void testConstructor() {
		@SuppressWarnings("unused")
		ConstructorTestClass constructorTestClass = new ConstructorTestClass();
	} // testConstructor

	/**
	*
	* @generated
	*/

	@Override
	protected EObject getObjectToTest() {
		return null;
	}

} // ImmunizationsSectionOperations