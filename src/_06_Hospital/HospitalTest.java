package _06_Hospital;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

/* 
 * 1. Create a Patient class capable of feeling cared for and having their pulse 
 * checked.
 * 
 * 2. Create a Doctor abstract class capable of doing medicine, holding a list 
 * of assigned Patients, assigning patients to the list and getting the list.
 * 
 * 3. Create a subclass of Doctor called GeneralPractitioner capable of making 
 * house calls.
 * 
 * 4. Create a subclass of Doctor called Surgeon capable of performing surgery. 
 * 
 * 5. Create a Hospital class capable of holding lists of Doctors and unassigned 
 * Patients, adding to both lists and assigning up to a maximum of 3 Patients to
 *  Doctors.
 * 
 * 6. Create a DoctorFullException. A Doctor should throw this exception 
 * whenever more than three patients are being assigned to them.
 * 
 * 7. Make all tests pass.
 */

public class HospitalTest extends TestCase {

	private Hospital testHospital = new Hospital();

	public void testAddDoctor() {
		testHospital.addDoc(new GeneralPractitioner());
		testHospital.addDoc(new GeneralPractitioner());
		testHospital.addDoc(new Surgeon());
		assertEquals(3, testHospital.getDoctors().size());
	}

	public void testAddPatient() throws Exception {
		testHospital.addPat(new Patient());
		testHospital.addPat(new Patient());
		testHospital.addPat(new Patient());
		assertEquals(3, testHospital.getPatients().size());
	}

	public void testDoctorsHaveSpecialties() throws Exception {

		Surgeon testSurgeon = new Surgeon();
		assertEquals(true, testSurgeon.canSurg());
		assertEquals(false, testSurgeon.canCall());

		GeneralPractitioner testGP = new GeneralPractitioner();
		assertEquals(true, testGP.canCall());
		assertEquals(false, testGP.canSurg());
	}

	public void testAssignDoctor() throws Exception {
		Doctor testDoctor = new GeneralPractitioner();
		try {
			testDoctor.addPatient(new Patient());
			assertEquals(1, testDoctor.giveList().size());
			testDoctor.addPatient(new Patient());
			assertEquals(2, testDoctor.giveList().size());
			testDoctor.addPatient(new Patient());
			assertEquals(3, testDoctor.giveList().size());
		} catch (DoctorFullException e) {
			e.printStackTrace();
		}
	}

	// When you check a patient's pulse, they feel cared for
	public void testCheckPulse() throws Exception {
		Patient testPatient = new Patient();
		// Note: Accessors for booleans typically don't use "get"
		assertEquals(false, testPatient.caredFor());
		testPatient.checkPulse();
		assertEquals(true, testPatient.caredFor());
	}

	// Doctors work on their Patients by checking their pulses.
	public void testDoctorsWork() throws Exception {
		Doctor testDoctor = new GeneralPractitioner();
		Patient max = new Patient();
		Patient macky = new Patient();
		try {
			testDoctor.addPatient(max);
			testDoctor.addPatient(macky);
		} catch (DoctorFullException e) {
			e.printStackTrace();
		}
		assertEquals(false, max.caredFor());
		assertEquals(false, macky.caredFor());
		testDoctor.doMedicine();
		assertEquals(true, max.caredFor());
		assertEquals(true, macky.caredFor());
	}

	public void testDoctorsCanOnlyHandle3Patients() throws Exception {
		GeneralPractitioner testDoctor = new GeneralPractitioner();

		try {
			testDoctor.addPatient(new Patient());
			testDoctor.addPatient(new Patient());
			testDoctor.addPatient(new Patient());
		} catch (DoctorFullException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			testDoctor.addPatient(new Patient());
			assertTrue(false);
		} catch (DoctorFullException dfe) {
			assertTrue(true);
		}
		assertTrue(testDoctor.giveList().size() == 3);
	}

	// Add 3 Doctors and 8 Patients to the testHospital for this test
	public void test8Patients() throws Exception {
		testHospital.addDoc(new GeneralPractitioner());
		testHospital.addDoc(new GeneralPractitioner());
		testHospital.addDoc(new Surgeon());
		for (int i =0; i<8; i++) {
			testHospital.addPat(new Patient());
		}
		testHospital.assignPats();

		List<Doctor> testDoctors = testHospital.getDoctors();
		assertEquals(3, testDoctors.get(0).giveList().size());
		assertEquals(3, testDoctors.get(1).giveList().size());
		assertEquals(2, testDoctors.get(2).giveList().size());
	}

}
