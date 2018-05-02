import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Course {

	// Declare Variables
	@SuppressWarnings("unused")
	private String name, ID, description, date;
	@SuppressWarnings("unused")
	private int noOfStudents;
	DatabaseHandler db = new DatabaseHandler();

	public Course(String name, String ID, String description, int noOfStudents) {
		this.name = name;
		this.ID = ID;
		this.description = description;
		this.noOfStudents = noOfStudents;
	}

	public void createCourse() {

		Connection database = db.getConnection();
		try {
			Statement statement = database.createStatement();
			String sql = "insert into course" + "  (ID, Name, Description, noOfStudents)"
			// + " values ('2', 'SEF', 'Software Engineering', '240')";
					+ " values ('" + this.ID + "', " + "'" + this.name + "', " + "'" + this.description + "', " + "'"
					+ this.noOfStudents + "')";
			statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	public String getName() {
		return this.name;
	}

	public String getID() {
		return this.ID;
	}

	public String getDescription() {
		return this.description;
	}

	public String getdate() {
		return this.date;
	}

	public int getNoOfStudents() {
		return this.noOfStudents;
	}

}
