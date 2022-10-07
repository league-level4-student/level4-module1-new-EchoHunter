package _06_Hospital;

import java.util.ArrayList;
	abstract class Doctor {
		ArrayList<Patient> listP = new ArrayList<Patient>();

		public void addPatient(Patient p) throws DoctorFullException {
			if (listP.size()==3) {
				throw new DoctorFullException();
			}
			listP.add(p);
		}

		public ArrayList<Patient> giveList() {
			return listP;
		}

		public void doMedicine() {
			for (int i = 0; i < listP.size(); i++) {
				listP.get(i).caredFor = true;
			}
		}

		public boolean canSurg() {
			return false;
		}

		public boolean canCall() {
			return false;

		}

	}
