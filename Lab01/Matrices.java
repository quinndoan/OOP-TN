package Lab01;
import java.util.Scanner;
public class Matrices {
    public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the row: ");
            int row = scanner.nextInt();
            System.out.println("Enter the columns: ");
            int column = scanner.nextInt();

            int[][] matrix1 = new int[row][column];
            int[][] matrix2 = new int[row][column];

            System.out.println("Nhap phan tu cho ma tran 1: ");
            for (int i=0;i< row; i++){
                for (int j=0;j<column;j++){
                    matrix1[i][j] = scanner.nextInt();
                }
            }

            System.out.println("Nhap phan tu cho ma tran 2: ");
            for (int i=0;i<row;i++){
                for (int j=0;j<column;j++){
                    matrix2[i][j]= scanner.nextInt();
                }
            }

            scanner.close();

            int[][] matrixAdd = new int[row][column];
            for (int i=0;i<row;i++){
                for (int j=0;j<column;j++){
                    matrixAdd[i][j] = matrix1[i][j] + matrix2[i][j];
                }
            }
            System.out.println("The result: ");
            for (int i=0;i<row;i++){
                for (int j=0;j<column;j++){
                    System.out.println(matrixAdd[i][j]+ " ");
                }
                System.out.println();
            }
    }
}
