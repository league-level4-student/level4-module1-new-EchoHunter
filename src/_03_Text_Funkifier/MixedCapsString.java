package _03_Text_Funkifier;

import java.util.Iterator;

public class MixedCapsString implements TextFunkifier {

    private String unfunkifiedText;

    public MixedCapsString(String unfunkifiedText) {

        this.unfunkifiedText = unfunkifiedText;

    }

	@Override
	public String funkifyText() {
		StringBuilder returned = new StringBuilder("");
		for (int i = 0; i <  unfunkifiedText.length(); i++) {
			if (i%2==1) {
				returned.append(unfunkifiedText.toUpperCase().charAt(i));
			}
			else {
			returned.append(unfunkifiedText.toLowerCase().charAt(i));
			}
			}
		return returned.toString();
	}

}
