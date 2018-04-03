

import java.time.*;
import java.util.Scanner;

public class DaysAndTimes {
// Version 1: With while loop (may take a while to figure out how to set this thing up properly)
	public static void main(String[] args) {
		String days[] = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		String startTimes[] = new String[5];
		String endTimes[] = new String[5];
		Scanner scan = new Scanner(System.in);
		//entering days and times sample
		for (int i=1; i<=5; i++) {
			String response = "";
			boolean YesNo = true;
			while (YesNo == true) {
				System.out.println("Are you available on " + days[i] + "s?");
				System.out.print("Y for yes, N for no: ");
				response = scan.nextLine();
				if (response == "Y" || response == "y") {
					System.out.printf("Enter starting time for %s in 24 hour hh:mm format: ", days[i]);
					startTimes[i] = scan.nextLine();
					System.out.printf("Enter ending time for %s in 24 hour hh:mm format: ", days[i]);
					endTimes[i] = scan.nextLine();
				}
				else if (response == "N" || response == "n")
					YesNo = false;
			};
		}
	}
}
