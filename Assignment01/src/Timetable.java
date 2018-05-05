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
		if (option == 3)
			System.out.println("Currently under construction.");
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

	public void viewTimetable(String courseID) {
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();
		try {
			Statement statement = database.createStatement();

			String sql = "SELECT timetable.ID, course.Name, staff.FirstName, staff.Lastname, timetable.date, timetable.time"
					+ " FROM timetable" + " INNER JOIN course on course.courseID=timetable.courseID"
					+ " INNER JOIN staff on staff.rmitID=timetable.rmitID" + " WHERE timetable.courseID=\"" + courseID
					+ "\"";

			ResultSet rs = statement.executeQuery(sql);

			System.out.println("Current timetable for " + courseID);
			while (rs.next())

				System.out.println("ID: " + rs.getString("ID") + " " + "FirstName: " + rs.getString("FirstName") + " "
						+ "LastName: " + rs.getString("LastName") + " " + "Date: " + rs.getString("Date") + " "
						+ "Time:" + rs.getString("time"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}