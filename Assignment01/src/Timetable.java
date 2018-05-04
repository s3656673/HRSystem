import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Timetable {

	private static final String ID = "2";
	private String date, time, courseID, rmitID;

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

		viewTimetable();

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

	public void viewTimetable() {
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();
		try {
			Statement statement = database.createStatement();

			String sql = "SELECT timetable.ID, course.Name, staff.FirstName, staff.Lastname, timetable.date, timetable.time"
					+ " FROM timetable" + " INNER JOIN course on course.courseID=timetable.courseID"
					+ " INNER JOIN staff on staff.rmitID=timetable.rmitID";

			ResultSet rs = statement.executeQuery(sql);
			System.out.println("Current timetable: ");
			while (rs.next())

				System.out.println("ID: " + rs.getString("ID") + " " + "FirstName: " + rs.getString("FirstName") + " "
						+ "LastName: " + rs.getString("LastName") + " " + "Date: " + rs.getString("Date") + " "
						+ "Time:" + rs.getString("time"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}