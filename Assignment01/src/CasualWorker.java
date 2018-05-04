import java.util.*;

public class CasualWorker extends Staff {

	
	public CasualWorker(String rmitID, String type, String firstName, String lastName, String password, String school,
			String phone, String workingHours) {
		super(rmitID, type, firstName, lastName, password, school, phone, workingHours);
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
			
		}

		if (option == 2)
			System.out.println("See open hours");

		if (option == 3)
			System.out.println("Apply for a course");

	}
	


}
