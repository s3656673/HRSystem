import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	private String typeOfStaff = "fail";
	private String name, firstName, lastName, rmitID, password, school, phone, workingHours;
	DatabaseHandler db = new DatabaseHandler();

	public Login() {
		Scanner scan = new Scanner(System.in);
		String username;
		String password;
		System.out.print("Please enter username: ");
		username = scan.next();
		System.out.print("Please enter password: ");
		password = scan.next();

		Connection database = db.getConnection();
		try {
			Statement statement = database.createStatement();
			String sql = "select * from staff where rmitID='" + username + "' and password ='" + password + "'";
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				System.out.println("Login successful");
				this.typeOfStaff = rs.getString("Type");
				this.firstName = rs.getString("FirstName");
				this.lastName = rs.getString("LastName");
				this.rmitID = rs.getString("rmitID");
				this.password = rs.getString("Password");
				this.school = rs.getString("School");
				this.phone = rs.getString("Phone");
				this.workingHours = rs.getString("WorkingHours");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String getType() {
		return this.typeOfStaff;
	}

	public String getTypeOfStaff() {
		return typeOfStaff;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRmitID() {
		return rmitID;
	}

	public String getPassword() {
		return password;
	}

	public String getSchool() {
		return school;
	}

	public String getPhone() {
		return phone;
	}

	public String getWorkingHours() {
		return workingHours;
	}

}
