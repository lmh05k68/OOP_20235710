//2.2.5 Lab 01
import javax.swing.JOptionPane;
public class Calculate {
    public static void main(String[] args){
        String strNum1 = JOptionPane.showInputDialog("So thu nhat");
        String strNum2 = JOptionPane.showInputDialog("So thu hai");
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double sub = num1 - num2;
        double multi = num1 * num2;
        double divide = num1/num2;
        if(num2 == 0){
            JOptionPane.showMessageDialog(null,"Error");
        } else {
            String message = "Tong: " + sum + "\n"
                            +"Hieu: " + sub + "\n"
                            +"Tich: " + multi + "\n"
                            +"Thuong: " + divide + "\n";
            JOptionPane.showMessageDialog(null, message, "Ket qua", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
