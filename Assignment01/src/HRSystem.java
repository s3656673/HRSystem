import java.util.*;

public class HRSystem {

	// Login method
	public static String login(Staff courseCoordinator, Staff casualWorker, Staff approver, Staff admin) {

		Scanner scan = new Scanner(System.in);
		String username;
		String password;
		System.out.print("Please enter username: ");
		username = scan.next();
		System.out.print("Please enter password: ");
		password = scan.next();

		// Check login
		if (username.equals(courseCoordinator.getRmitID())) {
			if (password.equals(courseCoordinator.getPassword()))
				System.out.println("Login success");
			return "courseCoordinator";
		}

		if (username.equals(casualWorker.getRmitID())) {
			if (password.equals(casualWorker.getPassword()))
				System.out.println("Login success");
			return "casualWorker";
		}

		if (username.equals(approver.getRmitID())) {
			if (password.equals(approver.getPassword()))
				System.out.println("Login success");
			return "approver";
		}

		if (username.equals(admin.getRmitID())) {
			if (password.equals(admin.getPassword()))
				System.out.println("Login success");
			return "admin";
		}

		return "fail";

	}

	public static void main(String[] args) {

		String typeOfStaff;

		// Declare types
		Course course = new Course("SEF", "COSC1111", "Software Engineer", "1/02/2018", 2);

		Staff courseCoordinator = new CourseCoordinator("Bill", "e523523", "password123", "RMIT", 441222212, 2,
				"Departmental", "Course");

		Staff casualWorker = new CasualWorker("Jill", "e123123", "password321", "RMIT", 22222, 4);

		Staff approver = new Approver("Will", "e456456", "password111", "RMIT", 222, 4);

		Staff admin = new Admin("Phil", "e789789", "password333", "RMIT", 222344, 6);

		// Authenticate to determine type of user (approver, admin,
		// courseCoordinator..etc)
		do {
			typeOfStaff = (login(courseCoordinator, casualWorker, approver, admin));
			if (typeOfStaff == "fail")
				System.out.println("Login failed, please try again");
			System.out.println();
		} while (typeOfStaff == "fail");

		System.out.println(typeOfStaff);
	
		if (typeOfStaff=="casualWorker")
		{
			casualWorker.menu();
		}
			

	}

}
