import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Timetable {

	// RETRIEVE FROM SERVER
	/*
	 * Connection database = db.getConnection(); try { Statement statement =
	 * database.createStatement(); String sql = "insert into course" +
	 * "  (courseID, Name, Description, noOfStudents)" // +
	 * " values ('2', 'SEF', 'Software Engineering', '240')"; + " values ('" +
	 * this.courseID + "', " + "'" + this.name + "', " + "'" + this.description +
	 * "', " + "'" + this.noOfStudents + "')"; statement.executeUpdate(sql);
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 */
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

		insertTable();

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
}