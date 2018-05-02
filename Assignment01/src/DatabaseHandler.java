import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHandler {

	
	public Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/sef";
			String username = "root";
			String password = "";
			Class.forName(driver);

			Connection con = DriverManager.getConnection(url, username, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void getCourse() {
		
	}
}