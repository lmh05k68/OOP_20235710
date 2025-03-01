//6.5
package sum;
import java.util.Scanner;
public class ArraySum {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("So phan tu cua mang: ");
		int n = keyboard.nextInt();
		int[] arr = new int[n];
		System.out.println("Nhap phan tu:");
		for(int i = 0; i < n; i++) {
			arr[i] = keyboard.nextInt();
		}
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += arr[i];
		}
		double avg = (double)sum/n;
		System.out.println("Tong: " + sum);
		System.out.println("Trung binh: " + avg);
	}
}
