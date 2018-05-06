import java.util.*;

public class CasualWorker extends Staff {

	private String rmitID;

	public CasualWorker(String rmitID, String type, String firstName, String lastName, String password, String school,
			String phone, String workingHours) {
		super(rmitID, type, firstName, lastName, password, school, phone, workingHours);
		this.rmitID = rmitID;
	}

	// Declare variables
	@Override
	public void menu() {
		int option;
		Scanner scan = new Scanner(System.in);

		do {

			System.out.println("Welcome casual worker!");
			System.out.println("1. View available hours");
			System.out.println("2. Apply for a course");
			System.out.println("3. Check course status");
			System.out.println();
			System.out.println("Please select an option: ");
			option = scan.nextInt();
		} while (option < 0 || option > 3);

		if (option == 1) {
			String courseID = null;
			System.out.println("Please enter courseID to apply for: ");
			courseID = scan.next();
			Availability availability = new Availability();

			availability.showAvailability(courseID);

		}

		if (option == 2) {
			System.out.println("Apply for a course");
		}
		if (option == 3) {
			Availability availability = new Availability();
			availability.checkStatus(rmitID);

		}

	}

}
