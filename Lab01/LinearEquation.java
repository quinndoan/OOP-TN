package Lab01;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.lang.Math;
public class LinearEquation {
    public static void main(String[] args){
        String NameCase = JOptionPane.showInputDialog(null, "Enter your case: ", JOptionPane.INFORMATION_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        switch (NameCase) {
            case "First Degree One Variable":
            //Scanner scanner = new Scanner(System.in);
            System.out.println("Nhap so: ");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            scanner.close();
            if (a!=0){
                double x = -b/a;
                System.out.println("Result: " + x);
            } 
            else System.out.println("No result");
    
                break;
            case "First Degree Two Variable":
            System.out.println("Enter the variables for equation 1: ");
            double a11 = scanner.nextDouble();
            double a12 = scanner.nextDouble();
            double b1 = scanner.nextDouble();
            System.out.println("Enter the variables for equation 2: ");
            double a21 = scanner.nextDouble();
            double a22 = scanner.nextDouble();
            double b2 = scanner.nextDouble();
            scanner.close();
            if ((a12 == 0 || a11==0) && a11 !=b1){
                System.out.println("No Solution");
            }
            else if ((a22 ==0 || a21==0) && a21 !=b2){
                System.out.println("No Solution");
            }
            else if (a11*a22 == a21*a12 && a11*b2 == a21*b1){
                System.out.println("Infinite Solution");

            }
            else if (a11*a22 == a21*a12 && a11*b2 != a21*b1){
                System.out.println("No Solution");
            }
            else {
                double x2 = (a11*b2 - b1*a21)/ (a22*a11-a12*a21);
                double x1 = (b1- a12*x2)/a11;
                System.out.println("x1: " +x1);
                System.out.println("x2: " +x2);

            }
            break;
            case "Second Degree One Variable":
            System.out.println("Nhap so: ");
                double a3 = scanner.nextDouble();
                double b3 = scanner.nextDouble();
                double c3 = scanner.nextDouble();
                scanner.close();
                if (a3==0){
                    double x = -c3/b3;
                    System.out.println("Result: "+x);
                }
                else {
                    double gamma= (b3*b3-4*a3*c3);
                    if (gamma<0){
                        System.out.println("No Solution");

                    }
                    else if (gamma==0){
                        double result = -b3/(2*a3);
                        System.out.println("Double root: "+ result);
                    }
                    else {
                        double x1 = (-b3 + Math.sqrt(gamma))/(2*a3);
                        System.out.println("x1: " + x1 + " ");
                        double x2 = (-b3 - Math.sqrt(gamma))/(2*a3);
                        System.out.println("x2: " + x2);
                    }
                }
                break;
            }
        }
    }

