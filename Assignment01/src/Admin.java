import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Admin extends Staff {

	public Admin(String rmitID, String type, String firstName, String lastName, String password, String school,
			String phone, String workingHours) {
		super(rmitID, type, firstName, lastName, password, school, phone, workingHours);
	}

	public int option = 0;

	@Override
	public void menu() {
		Scanner scan = new Scanner(System.in);

		do {

			System.out.println("Welcome administrator!");
			System.out.println("1. Import data");
			System.out.println("2. Export Data");
			System.out.println("3. Modify Data");
			System.out.println();
			System.out.println("Please select an option: ");
			option = scan.nextInt();
		} while (option < 0 || option >= 3);

		if (option == 1) {
			System.out.println("Please specify data import file: ");
			this.option = 1;
		}

		if (option == 2) {
			exportData();
			/*
			 * 1. Applied, Availability,Course,Rates,Staff,Timetable
			 */
		}
		if (option == 3) {
			this.option = 2;
			System.out.println("Which data would you like to modify: ");
		}
	}

	public void exportData() {
		String filename = null;
		int option = -1;
		String sql = null;
		DatabaseHandler db = new DatabaseHandler();
		Connection database = db.getConnection();
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("What data would you like to export: ");
			System.out.println("1. Export applied courses");
			System.out.println("2. Export Availability times");
			System.out.println("3. Export Course details");
			System.out.println("4. Export rates");
			System.out.println("5. Export staff details");
			System.out.println("6. Export timetable");
			option = scan.nextInt();
		} while (option < 0 || option > 6);

		if (option == 1) {
			// Export applied courses
		}
		if (option == 2) {
			// Export availability times
		}
		if (option == 3) {
			// Export course details
		}
		if (option == 4) {
			// Export rates
		}
		if (option == 5) {
			// Export staff details
		}
		if (option == 6) {
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("lawix10");
			HSSFRow rowhead = sheet.createRow((short) 0);
			rowhead.createCell((short) 0).setCellValue("ID");
			rowhead.createCell((short) 1).setCellValue("courseID");
			rowhead.createCell((short) 2).setCellValue("rmitID");
			rowhead.createCell((short) 3).setCellValue("time");
			rowhead.createCell((short) 4).setCellValue("date");

			int i = 1;
			try {
				sql = "select * from timetable";
				Statement statement = database.createStatement();
				ResultSet rs = statement.executeQuery(sql);
				System.out.println("Please enter filename: ");
				filename = scan.next();
				while (rs.next()) {
					HSSFRow row = sheet.createRow((short) i);

					row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("ID")));
					row.createCell((short) 1).setCellValue(rs.getString("courseID"));
					row.createCell((short) 2).setCellValue(rs.getString("rmitID"));
					row.createCell((short) 3).setCellValue(rs.getString("date"));
					row.createCell((short) 4).setCellValue(rs.getString("time"));

					i++;
				}

				String yemi = "C:\\Users\\Jonathan Ciminelli\\Desktop\\Software Engineering Fundamentals\\" + filename
						+ ".xls";
				FileOutputStream fileOut;
				try {
					fileOut = new FileOutputStream(yemi);
					workbook.write(fileOut);
					System.out.println("Timetable successfully exported");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			// Export timetable
		}

	}

}
