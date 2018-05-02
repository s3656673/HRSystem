import java.util.*;

public class HRSystem {



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
			Login login = new Login(courseCoordinator, casualWorker, approver,admin);
			typeOfStaff = login.getType();
			if (typeOfStaff == "fail")
				System.out.println("Login failed, please try again");
			System.out.println();
		} while (typeOfStaff == "fail");
		
	
		
		
		if (typeOfStaff=="casualWorker")
		{
			
			casualWorker.menu();
			
		}
			
		if (typeOfStaff=="admin")
		{
			
			admin.menu();
		}
		
		if (typeOfStaff=="approver")
		{
			
			approver.menu();
		}
		
		if (typeOfStaff=="courseCoordinator")
		{
			
			courseCoordinator.menu();
		}
	}

}
