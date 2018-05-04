import java.util.Scanner;

public class Approver extends Staff{

	public Approver(String rmitID, String type, String firstName, String lastName, String password, String school,
			String phone, String workingHours) {
		super(rmitID, type, firstName, lastName, password, school, phone, workingHours);
	}

	public int option = 0;
	@Override
	public void menu() {
		int option = this.option;
		int availableHrs;
		Scanner scan = new Scanner(System.in);
		
		do {

			System.out.println("Welcome approver!");
			System.out.println("1. Approve coordinators job entry applications");
			System.out.println("2. See budget allocation for discipline");
			System.out.println();
			System.out.println("Please select an option: ");
			option = scan.nextInt();
		} while (option < 0 || option >= 3);

		if (option == 1)
		{
			System.out.println("Please enter available hours: ");
			System.out.println("Notify casual academics of course approval.");
			this.option=1;
		}

		if (option == 2)
			this.option=2;
			System.out.println("See budget allocation for discipline");
	}

}
