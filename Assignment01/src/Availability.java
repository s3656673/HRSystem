import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Availability {

	public void showAvailability(String courseID) {
		String sql = null;
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();

		sql = "SELECT timetable.ID, timetable.date, timetable.time, availability.Status" + " FROM availability"
				+ " INNER JOIN timetable on timetable.ID=availability.ID" + " WHERE timetable.courseID='" + courseID
				+ "' AND availability.Status='Available'";

		try {
			Statement statement = database.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.print("TimetableID: " + rs.getString("ID") + " Date: " + rs.getString("date") + " Time: "
						+ rs.getString("time") + " Status: " + rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String checkStatus(String staffID) {
		String result = null;
		String sql = null;
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();

		sql = "SELECT timetable.courseID, timetable.date, timetable.time, applied.Status" + " FROM applied"
				+ " INNER JOIN availability on availability.ID=applied.ID"
				+ " INNER JOIN staff on staff.rmitID=applied.rmitID"
				+ " INNER JOIN timetable on timetable.ID=applied.timetableID" + " where applied.rmitID='" + staffID
				+ "'";

		try {
			Statement statement = database.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
			
				
				result = ("CourseID: " + rs.getString("courseID") + " Date: " + rs.getString("date") + " Time: "
						+ rs.getString("time") + " Status: " + rs.getString("Status"));
				
				System.out.println(result);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		

	}

	public boolean apply(String courseID, String rmitID) {
		Scanner scan = new Scanner(System.in);
		int ID;
		showAvailability(courseID);
		System.out.println();
		System.out.println("Please enter ID for course and time to apply for: ");
		ID = scan.nextInt();
		String sql = null;
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();
		sql = "INSERT INTO applied(ID, rmitID, timetableID, Status)" + " VALUES (1,'" + rmitID + "','" + ID
				+ "','Pending')";
		
		

		try {
			Statement statement = database.createStatement();
			statement.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
}