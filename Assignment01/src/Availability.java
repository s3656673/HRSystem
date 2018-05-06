import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Availability {

	private String courseID;

	public Availability(String courseID) {
		this.courseID = courseID;
	}

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
}