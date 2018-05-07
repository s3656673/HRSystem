
public class HRSystem {

	public static void main(String[] args) {

		String typeOfStaff = "fail";
		String firstName = null;
		String lastName = null;
		String rmitID = null;
		String password = null;
		String school = null;
		String phone = null;
		String workingHours = null;

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
			Staff courseCoordinator = new CourseCoordinator(rmitID, typeOfStaff, firstName, lastName, password, school,
					phone, workingHours);

			courseCoordinator.menu();
		}
		
		if (typeOfStaff.equals("casualWorker")) {
			Staff casualWorker = new CasualWorker(rmitID, typeOfStaff, firstName, lastName, password, school, phone, workingHours);
			
			casualWorker.menu();
		}
		
		if (typeOfStaff.equals("approver")){
			Staff approver = new Approver(rmitID, typeOfStaff, firstName, lastName, password, school, phone, workingHours);
			
			approver.menu();
		}

	}

}
