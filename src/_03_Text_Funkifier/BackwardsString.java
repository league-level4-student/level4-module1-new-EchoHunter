package _03_Text_Funkifier;

public class BackwardsString implements TextFunkifier {

    private String unfunkifiedText;

    public BackwardsString(String unfunkifiedText) {

        this.unfunkifiedText = unfunkifiedText;

    }

    @Override
    public String funkifyText() {
    	String returned ="";
    	for (int i = unfunkifiedText.length()-1; i >= 0; i--) {
			returned += unfunkifiedText.charAt(i);
		}
    	return returned;
    }
}
