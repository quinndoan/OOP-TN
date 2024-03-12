package Lab01;
//import javax.swing.JOptionPane;
import java.util.Scanner;

public class Month {
    public static void main(String[] args){
      //  String MonthCase = JOptionPane.showInputDialog(null," Enter the month", JOptionPane.INFORMATION_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the month: ");
        String MonthCase = scanner.nextLine();
        System.out.println("Enter the year: ");
        int yearInt = scanner.nextInt();
        switch (MonthCase){
            case "January":
            case "Jan":
            case "Jan.":
            case "1":
            case "March":
            case "Mar":
            case "Mar.":
            case "3":
            case "May":
            case "July":
            case "Jul":
            case "7":
            case "August":
            case "Aug":
            case "Aug.":
            case "8":
            case "October":
            case "Oct":
            case "Oct.":
            case "December":
            case "Dec":
            case "Dec.":
            System.out.println("Days of Month: 31");
            break;

            case "April":
            case "Apr":
            case "Apr.":
            case "4":
            case "June":
            case "Jun":
            case "6":
            case "September":
            case "Sept":
            case "Sept.":
            case "9":
            case "November":
            case "Nov":
            case "Nov.":
            case "11":
           System.out.println("Days of Month: 30");
           break;

           case "February":
           case "Feb.":
           case "Feb":
           case "2":
          // System.out.println("Enter the year: ");
           //int yearInt = scanner.nextInt();

           scanner.close();
           if (yearInt %100 ==0 && yearInt%400 !=0){
            System.out.println("Days of month: 28");
           }
           else if (yearInt%4 ==0){
            System.out.println("Days of month: 29");

           }
           else {
            System.out.println("Days of month: 28");
           }

        }
        

    }
}
