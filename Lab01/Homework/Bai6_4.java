//6.4
package date;
import java.util.Scanner;
public class Bai6_4 {
	public static boolean leapYear(int year) {
		return (year % 4 == 0 && year % 100 == 0 || (year % 400) == 0);
	}
	public static int getDay(String month, int year) {
		switch(month) {
		case "january": case "jan": case "1":
		case "march": case "mar": case "3":
		case "may": case "5":
		case "july": case "jul": case "7":
		case "august": case "aug": case "8":
		case "october": case "oct": case "10":
		case "december": case "dec": case "12":
			return 31;
		case "april": case "apr": case "4":
		case "june": case "jun": case "6":
		case "september": case "sep": case "9":
		case "november": case "nov": case "11":
			return 30;
		case "february": case "feb": case "2":
			return leapYear(year) ? 29 : 28;
		default: 
			return -1;
		}
	}
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		while(true) {
			System.out.print("Thang: ");
			String month = keyboard.next().toLowerCase();
			System.out.print("Nam: ");
			int year = keyboard.nextInt();
			if(year < 0) {
				System.out.println("Error");
				
			} else {
				int day = getDay(month,year);
				if(day < 0) {
					System.out.println("Error");
				} else {
					System.out.println("So ngay: " + day);
					break;
				}
			}
		}
	}
}
