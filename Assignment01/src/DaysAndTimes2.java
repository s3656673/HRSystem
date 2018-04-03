

import java.time.*;
import java.util.Scanner;

public class DaysAndTimes2 {
// Version 2: No while loop (may be tedious)
	public static void main(String[] args) {
		String days[] = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
		String startTimes[] = new String[6];
		String endTimes[] = new String[6];
		Scanner scan = new Scanner(System.in);
		//entering days and times sample
		for (int i=1; i<=5; i++) {
			String response = "";
			System.out.println("Entering times. Feel free to skip with Enter if a particular day is not applicable to you.");
			System.out.printf("Enter starting time for %s in 24 hour hh:mm format: ", days[i]);
			startTimes[i] = scan.nextLine();
			System.out.printf("Enter ending time for %s in 24 hour hh:mm format: ", days[i]);
			endTimes[i] = scan.nextLine();
		}
		for (int i=1; i<=5; i++) {
			if (startTimes[i] == null && endTimes[i] == null)
				System.out.printf("Times not allocated for %s", days[i]);
			else
				System.out.printf("Times for %s are: %s to %s\n", days[i], startTimes[i], endTimes[i]);
		}
	}
}
