//6.3
package b6_3;
import java.util.Scanner;
public class Bai6_3 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("n: ");
		int n = keyboard.nextInt();
		for(int i = 1; i <=n; i++) {
			for(int j = 1; j <= 2*i - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
