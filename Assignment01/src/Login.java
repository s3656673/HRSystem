import java.util.Scanner;

public class Login {
	public String typeOfStaff = "fail";
	
	public Login(Staff courseCoordinator, Staff casualWorker, Staff approver, Staff admin) {
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
		this.typeOfStaff="courseCoordinator";
	}

	if (username.equals(casualWorker.getRmitID())) {
		if (password.equals(casualWorker.getPassword()))
			System.out.println("Login success");
		this.typeOfStaff="casualWorker";
	}

	if (username.equals(approver.getRmitID())) {
		if (password.equals(approver.getPassword()))
			System.out.println("Login success");
		this.typeOfStaff="approver";
	}

	if (username.equals(admin.getRmitID())) {
		if (password.equals(admin.getPassword()))
			System.out.println("Login success");
		this.typeOfStaff="admin";
	}

	
	}
	
	public String getType()
	{
		return this.typeOfStaff;
	}
	
	
	
}
