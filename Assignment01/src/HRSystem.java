import java.util.*;

public class HRSystem {

	public static void main(String[] args) {

		String typeOfStaff = "fail";
		String firstName = null;
		String lastName = null;
		String rmitID = null;
		String password = null;
		String school = null;
		String phone = null;
		int phNum = 0;
		String workingHours = null;

		// Declare types
		/*
		 * Staff courseCoordinator = new CourseCoordinator("Bill", "e523523",
		 * "password123", "RMIT", 441222212, 2, "Departmental", "Course");
		 * 
		 * Staff casualWorker = new CasualWorker("Jill", "e123123", "password321",
		 * "RMIT", 22222, 4);
		 * 
		 * Staff approver = new Approver("Will", "e456456", "password111", "RMIT", 222,
		 * 4);
		 * 
		 * Staff admin = new Admin("Phil", "e789789", "password333", "RMIT", 222344, 6);
		 */

		// Authenticate to determine type of user (approver, admin,
		// courseCoordinator..etc)
		/*
		 * do { Login login = new Login(); typeOfStaff = login.getType(); if
		 * (typeOfStaff == "fail") System.out.println("Login failed, please try again");
		 * System.out.println(); } while (typeOfStaff == "fail");
		 */

		do {
			Login login = new Login();
			typeOfStaff = login.getType();
			if (typeOfStaff == "fail")
				System.out.println("Login failed, please try again" + "\n");
			else {
				firstName = login.getFirstName();
				lastName = login.getLastName();
				rmitID = login.getRmitID();
				password = login.getPassword();
				school = login.getSchool();
				phone = login.getPhone();
				workingHours = login.getWorkingHours();
			}
		} while (typeOfStaff == "fail");

		if (typeOfStaff.equals("courseCoordinator")) {
			Staff courseCoordinator = new CourseCoordinator(rmitID, typeOfStaff,firstName,lastName,password,school,phone,workingHours);
			
			System.out.println(rmitID);
			System.out.println(typeOfStaff);
			System.out.println(firstName);
			System.out.println(lastName);
			System.out.println(password);
			System.out.println(school);
			System.out.println(phone);
			System.out.println(workingHours);
			
		}

		/*
		 * if (typeOfStaff=="casualWorker") {
		 * 
		 * 
		 * }
		 * 
		 * if (typeOfStaff=="admin") {
		 * 
		 * admin.menu(); }
		 * 
		 * if (typeOfStaff=="approver") {
		 * 
		 * approver.menu(); }
		 */

	}

}
