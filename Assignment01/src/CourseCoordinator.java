import java.util.Scanner;

public class CourseCoordinator extends Staff {

	public CourseCoordinator(String rmitID, String type, String firstName, String lastName, String password,
			String school, String phone, String workingHours) {
		super(rmitID, type, firstName, lastName, password, school, phone, workingHours);
	}

	/*
	 * public String getSchool() { return this.school; }
	 * 
	 * public String getDepartment() { return this.department; }
	 * 
	 * public String getCourse() { return this.course; }
	 */

	public int option = 0;

	@Override
	public void menu() {
		Scanner scan = new Scanner(System.in);

		do {

			System.out.println("Welcome course coordinator!");
			System.out.println("1. View and modify timetable");
			System.out.println("2. View and modify hours and rates");
			System.out.println("3. Create course");
			System.out.println();
			System.out.println("Please select an option: ");
			option = scan.nextInt();
		} while (option < 0 || option > 3);

		if (option == 1) {
			Timetable timetable = new Timetable();
			timetable.options();
		}

		if (option == 2) {
			Rates rates = new Rates();
			rates.options();
		}

		if (option == 3) {

			CreateCourse createCourse = new CreateCourse();
			createCourse.createCourse();

		}

	}

}
