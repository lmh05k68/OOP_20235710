//6.6
package matrix;
import java.util.Scanner;
public class MatrixAdd {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("So hang: ");
		int row = keyboard.nextInt();
		System.out.print("So cot: ");
		int column = keyboard.nextInt();
		int[][] matrix1 = new int[row][column];
		int[][] matrix2 = new int[row][column];
		int[][] matrixSum = new int[row][column];
		System.out.println("Ma tran 1: ");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				matrix1[i][j] = keyboard.nextInt();
			}
		}
		System.out.println("Ma tran 2: ");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				matrix2[i][j] = keyboard.nextInt();
			}
		}
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				matrixSum[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		System.out.println("Ket qua: ");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				System.out.print(matrixSum[i][j] + " ");
			}
			System.out.println();
		}
	}
}
