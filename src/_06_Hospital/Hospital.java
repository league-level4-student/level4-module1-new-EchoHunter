package _06_Hospital;

import java.util.ArrayList;

public class Hospital {
	
		ArrayList<Doctor> docs = new ArrayList<Doctor>();
		ArrayList<Patient> unassignedPats = new ArrayList<Patient>();

		public void addDoc(Doctor d) {
			docs.add(d);
		}

		public void addPat(Patient p) {
			unassignedPats.add(p);
		}


		public void assignPats() {
			for (int i = 0; i < unassignedPats.size(); i++) {
				if (docs.get(i%docs.size()).giveList().size() < 3) {
					try{ docs.get(i%docs.size()).addPatient(unassignedPats.get(i));
					}catch(DoctorFullException e){
						e.printStackTrace();
					}
				}
				
			}
			unassignedPats.removeAll(unassignedPats);
		}

		public ArrayList<Doctor> getDoctors() {
			// TODO Auto-generated method stub
			return docs;
		}

		public ArrayList<Patient> getPatients() {
			// TODO Auto-generated method stub
			return unassignedPats;
		}
	}

