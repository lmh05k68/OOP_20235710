//2.2.6 Lab 01
import javax.swing.JOptionPane;
public class Equation {
    private static void bacNhat1An(){
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhap a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhap b:"));
        if(a == 0){
            JOptionPane.showMessageDialog(null,"Error");
        } else {
            double x = -b/a;
            JOptionPane.showMessageDialog(null,"x = " + x,"Ket qua", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private static void heBacNhat2An(){
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a11:"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a12:"));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Nhap b1:"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a21:"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhap a22:"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Nhap b2:"));
        double D = a11 * a22 - a12 * a21;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
        if(D == 0){
            if(D1 == 0 && D2 == 0){
                JOptionPane.showMessageDialog(null,"Vo so nghiem");
            } else {
                JOptionPane.showMessageDialog(null,"Vo nghiem");
            }
        } else {
            double x1 = D1/D;
            double x2 = D2/D;
            JOptionPane.showMessageDialog(null,"x1 = " + x1 + "\nx2 = " + x2,"Ket qua",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private static void bac2(){
        double a = Double.parseDouble(JOptionPane.showInputDialog("Nhap a:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Nhap b:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Nhap c:"));
        if(a == 0){
            JOptionPane.showMessageDialog(null,"Error");
        }
        double delta = b*b - 4*a*c;
        if(delta > 0){
            double x1 = (-b + Math.sqrt(delta)) / 2 / a;
            double x2 = (-b - Math.sqrt(delta)) / 2 / a;
            JOptionPane.showMessageDialog(null,"x1 = " + x1 + "\nx2 = " + x2,"Ket qua",JOptionPane.INFORMATION_MESSAGE);
        } else if(delta == 0){
            double x = -b/2/a;
            JOptionPane.showMessageDialog(null,"Nghiem kep x = " + x,"Ket qua",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,"Vo nghiem");
        }
    }
    public static void main(String[] args){
        String[] options = {"PT bac nhat 1 an", "He PT bac nhat 2 an", "PT bac 2"};
        int choice = JOptionPane.showOptionDialog(null,"Chon:","",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
        switch(choice){
            case 0:
                bacNhat1An();
                break;
            case 1:
                heBacNhat2An();
                break;
            case 2:
                bac2();
                break;
        }
    }
}
