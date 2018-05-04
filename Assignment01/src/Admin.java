import java.util.Scanner;

public class Admin extends Staff {

	public Admin(String rmitID, String type, String firstName, String lastName, String password, String school,
			String phone, String workingHours) {
		super(rmitID, type, firstName, lastName, password, school, phone, workingHours);
	}

	public int option = 0;

	@Override
	public void menu() {
		int availableHrs;
		Scanner scan = new Scanner(System.in);

		do {

			System.out.println("Welcome administrator!");
			System.out.println("1. Import data");
			System.out.println("2. Export Data");
			System.out.println("3. Modify Data");
			System.out.println();
			System.out.println("Please select an option: ");
			option = scan.nextInt();
		} while (option < 0 || option >= 3);

		if (option == 1) {
			System.out.println("Please specify data import file: ");
			this.option = 1;
		}

		if (option == 2) {
			this.option = 2;
			System.out.println("Enter export destination: ");
		}
		if (option == 3) {
			this.option = 2;
			System.out.println("Which data would you like to modify: ");
		}
	}

}
