//6.1
package JavaBasics;
import javax.swing.JOptionPane;
public class ChooseOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null,
				"Do you want to change to the first class ticket?");
		JOptionPane.showMessageDialog(null,"You've chosen "
				+ (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
		System.exit(0);
	}
}
