import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin extends Staff {

	public Admin(String rmitID, String type, String firstName, String lastName, String password, String school,
			String phone, String workingHours) {
		super(rmitID, type, firstName, lastName, password, school, phone, workingHours);
	}

	public int option = 0;

	@Override
	public void menu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		do {

			System.out.println("Welcome administrator!");
			System.out.println("1. Import data");
			System.out.println("2. Export Data");
			System.out.println("3. Modify Data");
			System.out.println();
			System.out.println("Please select an option: ");
			option = scan.nextInt();
		} while (option < 0 || option > 3);

		if (option == 1) {
			System.out.println("Please specify data import file: ");
			this.option = 1;
		}

		if (option == 2) {
			ExportData exportData = new ExportData();
			exportData.exportData();
		}
		if (option == 3) {
			modifyData();

		}
	}

	public void modifyData() {
		Scanner scan = new Scanner(System.in);
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();
		String sql = null;
		int option = -1;
		int option2 = -1;
		int ID;
		do {
			System.out.println("Which data would you like to modify: ");
			System.out.println("1. Modify applied courses");
			System.out.println("2. Modify availablity times");
			System.out.println("3. Modify course details");
			System.out.println("4. Modify rates");
			System.out.println("5. Modify staff details");
			System.out.println("6. Modify timetable");
			option = scan.nextInt();
		} while (option <= 0 || option > 6);

		if (option == 1) {
			sql = "select * from applied";
			try {

				Statement statement = database.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				while (rs.next()) {
					System.out.println("ID: " + rs.getString("ID") + " rmitID: " + rs.getString("rmitID")
							+ " timetableID: " + rs.getString("timetableID") + " Status: " + rs.getString("Status"));
				}
				System.out.println("Please enter ID of applied course you wish to modify: ");
				ID = scan.nextInt();
				System.out.println("What would you like to modify?");
				System.out.println("1. Modify rmitID");
				System.out.println("2. Modify timetableID");
				System.out.println("3. Modify Status");
				option2 = scan.nextInt();

				if (option2 == 1) {
					String rmitID = null;
					System.out.println("Please enter new rmitID: ");
					rmitID = scan.next();
					sql = "UPDATE applied" + " SET rmitID = " + "'" + rmitID + "'" + " WHERE ID = " + ID;
				}

				if (option2 == 2) {
					int timetableID = 0;
					System.out.println("Please enter timetableID: ");
					timetableID = scan.nextInt();
					sql = "UPDATE applied" + " SET timetableID = " + "'" + timetableID + "'" + " WHERE ID = " + ID;
				}

				if (option2 == 3) {
					String status = null;
					System.out.println("Please enter new status: ");
					status = scan.next();
					// Modify status

					sql = "UPDATE applied" + " SET Status = " + "'" + status + "'" + " WHERE ID = " + ID;
				}

				try {
					statement.executeUpdate(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		if (option == 2) {
			// Modify applied courses
		}

		if (option == 3) {
			// Modify applied courses
		}

		if (option == 4) {
			// Modify applied courses
		}

		if (option == 5) {
			// Modify applied courses
		}

		if (option == 6) {
			// Modify applied courses
		}

	}

}
