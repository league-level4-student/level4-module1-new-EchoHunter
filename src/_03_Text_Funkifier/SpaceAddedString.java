package _03_Text_Funkifier;
import java.util.Iterator;
public class SpaceAddedString implements TextFunkifier {
	private String unfunkifiedText;
	public SpaceAddedString(String unfunkifiedText) {
		this.unfunkifiedText = unfunkifiedText;
	}
	public String funkifyText() {
		StringBuilder returned = new StringBuilder("");
		for (int i = 0; i < unfunkifiedText.length(); i++) {
			returned.append(unfunkifiedText.charAt(i));
			if (i != unfunkifiedText.length() - 1) {
				if ((returned.charAt(returned.length() - 1) != ' ')
						&& (unfunkifiedText.charAt(i + 1) != ' ')) {
					returned.append(" ");
				}
			}
		}
		return returned.toString();
	}
}
