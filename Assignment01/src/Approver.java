import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Approver extends Staff {

	public Approver(String rmitID, String type, String firstName, String lastName, String password, String school,
			String phone, String workingHours) {
		super(rmitID, type, firstName, lastName, password, school, phone, workingHours);
	}

	@Override
	public void menu() {
		Scanner scan = new Scanner(System.in);
		// 1. View applied casual workers
		// 2. Apply or decline a casual worker job

		int option = -1;
		do {
			System.out.println();
			System.out.println("Welcome approver!");
			System.out.println("1. View applied courses");
			System.out.println("2. Apply or decline a casual worker job.");
			option = scan.nextInt();
		} while (option <= 0 || option > 2);

		if (option == 1) {
			viewApplied();
		}

		if (option == 2) {
			setStatus();
		}

	}

	public void viewApplied() {
		String sql = null;
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();

		sql = "SELECT *\r\n" + "FROM applied\r\n" + "WHERE Status='Pending'";

		try {
			Statement statement = database.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.println("ID: " + rs.getString("ID") + " rmitID: " + rs.getString("rmitID") + " timetableID: "
						+ rs.getString("timetableID") + " Status: " + rs.getString("Status"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setStatus() {
		viewApplied();
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();
		String sql = null;
		Scanner scan = new Scanner(System.in);
		int ID;
		int option = -1;
		System.out.println("Please enter ID: ");
		ID = scan.nextInt();

		do {
			System.out.println("Please select an option: ");
			System.out.println("1. Approve course");
			System.out.println("2. Decline course");
			option = scan.nextInt();
		} while (option <= 0 || option > 2);

		if (option == 1) {
			sql = "UPDATE applied" + " SET status = 'Approved'" + " WHERE ID = " + ID;
		}

		if (option == 2) {
			sql = "UPDATE applied" + " SET status = 'Denied'" + " WHERE ID = " + ID;
		}

		try {
			Statement statement = database.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
