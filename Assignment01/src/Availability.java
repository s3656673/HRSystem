import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public void checkStatus(String staffID) {
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
				System.out.print("CourseID: " + rs.getString("courseID") + " Date: " + rs.getString("date") + " Time: "
						+ rs.getString("time") + " Status: " + rs.getString("Status"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}