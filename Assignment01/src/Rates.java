import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Rates {

	/*
	 * Input and modify rates
	 */

	private String ID, rmitID, courseID, hours, rates;

	public void options() {
		Scanner scan = new Scanner(System.in);
		int option = -1;
		do {
			System.out.println("---Rates for staff---");
			System.out.println("Please select an option: ");
			System.out.println("1. Input rates");
			System.out.println("2. Modify rates");
			System.out.println("3. View rates");
			option = scan.nextInt();
		} while (option <= 0 || option > 3);

		if (option == 1)
			inputRates();

		if (option == 2) {
			System.out.print("Please enter staffID to modify: ");
			rmitID = scan.next();
			modifyRates(rmitID);
		}

		if (option == 3) {
			System.out.print("Please enter staffID to view rate: ");
			rmitID = scan.next();
			viewRates(rmitID);
		}

	}

	public void inputRates() {
		Scanner scan = new Scanner(System.in);
		String sql = null;
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();

		System.out.print("Please enter course ID: ");
		courseID = scan.next();
		System.out.print("Please enter staff ID: ");
		rmitID = scan.next();
		System.out.print("Please enter hours staff will be working for course: ");
		hours = scan.next();
		System.out.print("Please enter hourly rate: ");
		rates = scan.next();

		sql = "INSERT INTO `rates`(`ID`, `rmitID`, `courseID`, `hours`, `rates`)\r\n" + "VALUES(1,'" + rmitID + "',"
				+ "'" + courseID + "'," + "'" + hours + "'," + "'" + rates + "')";

		try {
			Statement statement = database.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void viewRates(String rmitID) {
		String sql = null;
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();

		System.out.println("Rates for: " + rmitID);

		try {
			Statement statement = database.createStatement();
			sql = "SELECT * FROM `rates` WHERE rmitID = '" + rmitID + "'";

			ResultSet rs = statement.executeQuery(sql);
			while (rs.next())
				System.out.println("ID: " + rs.getString("ID") + " " + "CourseID: " + rs.getString("courseID") + " "
						+ "Hours: " + rs.getString("hours") + " " + "Rates: " + rs.getString("rates"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void viewCourseRates(String courseID) {
		String sql = null;
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();

		System.out.println("Rates for: " + courseID);

		try {
			Statement statement = database.createStatement();
			sql = "SELECT * FROM `rates` WHERE courseID = '" + courseID + "'";

			ResultSet rs = statement.executeQuery(sql);
			while (rs.next())
				System.out.println("ID: " + rs.getString("ID") +
						" CourseID: " + rs.getString("courseID") +
						" Hours: " + rs.getString("hours") + 
						" Rates: " + rs.getString("rates"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void modifyRates(String rmitID) {
		String newRMITID, newCourseID, newHours, newRates;
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();
		int ID;
		String sql = null;
		int option = -1;
		Scanner scan = new Scanner(System.in);
		viewRates(rmitID);
		System.out.println();
		System.out.print("Please enter ID to modify rate: ");
		ID = scan.nextInt();

		do {
			System.out.println("Please select an option: ");
			System.out.println("1. Modify staffID");
			System.out.println("2. Modify courseID");
			System.out.println("3. Modify hours");
			System.out.println("4. Modify rates");
			option = scan.nextInt();
		} while (option <= 0 || option > 4);

		if (option == 1) {
			System.out.println("Please enter new StaffID: ");
			newRMITID = scan.next();
			sql = "UPDATE rates" + " SET rmitID = '" + newRMITID + "'" + " WHERE ID = " + ID;

		}

		if (option == 2) {
			System.out.println("Please enter courseID: ");
			newCourseID = scan.next();
			sql = "UPDATE rates" + " SET courseID = '" + newCourseID + "'" + " WHERE ID = " + ID;
		}

		if (option == 3) {
			System.out.println("Please enter hours: ");
			newHours = scan.next();
			sql = "UPDATE rates" + " SET hours = '" + newHours + "'" + " WHERE ID = " + ID;
		}

		if (option == 4) {
			System.out.println("Please enter rates: ");
			newRates = scan.next();
			sql = "UPDATE rates" + " SET rates = '" + newRates + "'" + " WHERE ID = " + ID;

		}

		try {
			Statement statement = database.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
