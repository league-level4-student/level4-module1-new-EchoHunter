package _06_Hospital;

public class Surgeon extends Doctor {
	public boolean canSurg() {
		return true;
	}

	public void doSurgery() {
		for (int i = 0; i < listP.size(); i++) {
			listP.get(i).caredFor = true;
		}
	}
}
