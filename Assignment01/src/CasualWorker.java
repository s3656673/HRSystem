import java.util.*;

public class CasualWorker extends Staff {

	
	public void DaysAndTimes() {
		// Version 2: No while loop (may be tedious)
		String days[] = { "", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
		String startTimes[] = new String[6];
		String endTimes[] = new String[6];
		Scanner scan = new Scanner(System.in);
		// entering days and times sample
		for (int i = 1; i <= 5; i++) {
			String response = "";
			System.out.println(
					"Entering times. Feel free to skip with Enter if a particular day is not applicable to you.");
			System.out.printf("Enter starting time for %s in 24 hour hh:mm format: ", days[i]);
			startTimes[i] = scan.nextLine();
			System.out.printf("Enter ending time for %s in 24 hour hh:mm format: ", days[i]);
			endTimes[i] = scan.nextLine();
		}
		for (int i = 1; i <= 5; i++) {
			if (startTimes[i] == null && endTimes[i] == null)
				System.out.printf("Times not allocated for %s", days[i]);
			else
				System.out.printf("Times for %s are: %s to %s\n", days[i], startTimes[i], endTimes[i]);
		}
	}
	
	public CasualWorker(String name, String rmitID, String password, String school, int phone, int workingHours) {
		super(name, rmitID, password, school, phone, workingHours);
	}

	// Declare variables
	@Override
	public void menu() {
		int option;
		int availableHrs;
		Scanner scan = new Scanner(System.in);
		
		do {

			System.out.println("Welcome casual worker!");
			System.out.println("1. State available hours");
			System.out.println("2. See open hours");
			System.out.println("3. Apply for a course");
			System.out.println();
			System.out.println("Please select an option: ");
			option = scan.nextInt();
		} while (option < 0 || option >= 3);

		if (option == 1)
		{
			System.out.println("Please enter available hours: ");
			DaysAndTimes();
			
		}

		if (option == 2)
			System.out.println("See open hours");

		if (option == 3)
			System.out.println("Apply for a course");

	}
	


}
