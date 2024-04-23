package hust_soict_globalict_lab01;
import javax.swing.JOptionPane;
public class Caculate {
    public static void main(String[] args){
        String strNum1, strNum2;
        String strNotification = "Result: ";
        strNum1 = JOptionPane.showInputDialog(null,"Enter first double number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Enter second double number", JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1+ num2;
        String strsum = String.valueOf(sum);
        strNotification += "Sum: " + strsum + " and ";

        double difference = Math.abs(num1 - num2);
        String strdiff = String.valueOf(difference);
        strNotification += "Difference: "+ strdiff + " and ";

        double product = num1*num2;
        String strProduct = String.valueOf(product);
        strNotification += "Product: "+ strProduct + " and ";
        double quoient = num1/num2;
        String strQuoient = String.valueOf(quoient);
        strNotification += "Quoient: "+ strQuoient;
        JOptionPane.showMessageDialog(null, strNotification, "Show result: ", JOptionPane.INFORMATION_MESSAGE);
    }
}
