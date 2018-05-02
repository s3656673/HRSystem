import java.util.Scanner;

public class CourseCoordinator extends Staff {

	private String school, department, course;

	// Private assignShift()??
	// String name, String rmitID, String password, String school, int phone, int
	// workingHours
	public CourseCoordinator(String name, String rmitID, String password, String school, int phone, int workingHours, String department, String course) {
		super(name,rmitID,password,school,phone,workingHours);
		this.school = school;
		this.department = department;
		this.course = course;
	}

	public String getSchool() {
		return this.school;
	}

	public String getDepartment() {
		return this.department;
	}

	public String getCourse() {
		return this.course;
	}

	public int option = 0;
	@Override
	public void menu() {
		int availableHrss;
		Scanner scan = new Scanner(System.in);
		
		do {

			System.out.println("Welcome course coordinator!");
			System.out.println("1. Assign casual staff");
			System.out.println("2. Input Rates");
			System.out.println();
			System.out.println("Please select an option: ");
			option = scan.nextInt();
		} while (option < 0 || option >= 3);

		if (option == 1)
		{
			System.out.println("Enter staff to associate: ");
			this.option=1;
		}

		if (option == 2)
			this.option=2;
			System.out.println("Input rates: ");


	}

}
