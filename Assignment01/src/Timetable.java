import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Timetable {

	private String date, time, courseID, rmitID, ID;

	public void options() {
		int option = -1;
		String courseID = null;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Please select an options: ");
			System.out.println();
			System.out.println("1. Create a timetable");
			System.out.println("2. View timetable");
			System.out.println("3. Update timetable");
			option = scan.nextInt();
		} while (option <= 0 || option > 3);

		if (option == 1)
			createTimetable();
		if (option == 2) {
			System.out.println("Please enter courseID to view timetable for: ");
			courseID = scan.next();
			viewTimetable(courseID);
		}
		if (option == 3) {
			System.out.println("Please enter the courseID you wish to modify: ");
			courseID = scan.next();
			updateTimetable(courseID);
		}
	}

	public void getCourses() {
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();
		try {
			Statement statement = database.createStatement();
			String sql = "SELECT courseID, Name FROM course";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next())
				System.out.println(rs.getString("courseID") + " " + rs.getString("Name"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createTimetable() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Available courses");
		getCourses();
		System.out.print("Please enter courseID to add a timetable: ");
		courseID = scan.nextLine();
		System.out.print("Please enter staff to associate to class: ");
		rmitID = scan.nextLine();
		System.out.print("Please enter date: ");
		date = scan.nextLine();
		System.out.print("Please enter time: ");
		time = scan.nextLine();

		viewTimetable(courseID);

	}

	public void insertTable() {
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();
		try {
			Statement statement = database.createStatement();

			String sql = "INSERT into timetable(ID, courseID, rmitID, date, time)" + " VALUES('" + this.ID + "'," + "'"
					+ this.courseID + "'," + "'" + this.rmitID + "'," + "'" + this.date + "'," + "'" + this.time + "')";

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String viewTimetable(String courseID) {
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();
		String result = null;
		try {
			Statement statement = database.createStatement();

			String sql = "SELECT timetable.ID, course.Name, staff.FirstName, staff.Lastname, timetable.date, timetable.time"
					+ " FROM timetable" + " INNER JOIN course on course.courseID=timetable.courseID"
					+ " INNER JOIN staff on staff.rmitID=timetable.rmitID" + " WHERE timetable.courseID=\"" + courseID
					+ "\"";

			ResultSet rs = statement.executeQuery(sql);

			System.out.println("Current timetable for " + courseID);
			while (rs.next())

				result = ("ID: " + rs.getString("ID") + " " + "FirstName: " + rs.getString("FirstName") + " "
						+ "LastName: " + rs.getString("LastName") + " " + "Date: " + rs.getString("Date") + " "
						+ "Time:" + rs.getString("time"));
				/*System.out.println("ID: " + rs.getString("ID") + " " + "FirstName: " + rs.getString("FirstName") + " "
						+ "LastName: " + rs.getString("LastName") + " " + "Date: " + rs.getString("Date") + " "
						+ "Time:" + rs.getString("time"));*/
			System.out.println(result);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void updateTimetable(String courseID) {
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();
		String sql = "";

		int option = -1;
		int ID;
		String newCourseID, newStaffID, newDate, newTime;
		Scanner scan = new Scanner(System.in);
		viewTimetable(courseID);
		System.out.println();
		System.out.print("Please enter the ID for the timetable you wish to update: ");
		ID = scan.nextInt();
		System.out.println("What would you like to update for timetable " + ID);
		System.out.println("1. Update Course");
		System.out.println("2. Update Staff");
		System.out.println("3. Update date");
		System.out.println("4. Update time");
		option = scan.nextInt();

		if (option == 1) {
			System.out.print("Please enter new courseID: ");
			newCourseID = scan.next();
			sql = "UPDATE timetable\r\n" + "SET courseID = '" + newCourseID + "'" + "\r\n" + "WHERE ID = " + ID;
		}

		if (option == 2) {
			System.out.print("Please enter new staff ID: ");
			newStaffID = scan.next();
			sql = "UPDATE timetable\r\n" + "SET rmitID = '" + newStaffID + "'" + "\r\n" + "WHERE ID = " + ID;
		}

		if (option == 3) {
			System.out.print("Please enter new date: ");
			newDate = scan.next();
			sql = "UPDATE timetable\r\n" + "SET date = '" + newDate + "'" + "\r\n" + "WHERE ID = " + ID;
		}

		if (option == 4) {
			System.out.println("Please enter new time: ");
			newTime = scan.next();
			sql = "UPDATE timetable\r\n" + "SET time = '" + newTime + "'" + "\r\n" + "WHERE ID = " + ID;
		}

		try {
			Statement statement = database.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}