import java.util.*;

public class CreateCourse {

	private Scanner scan = new Scanner(System.in);
	
	//Declare variables for creating a course
	private String courseName, courseDescription, courseDate;
	private String courseID;
	private int noOfStudents;
	
	//Declare variables for defining a timetable

	Course course;

	public void createCourse() {

		// Create a course
		System.out.println("--Create course--");
		System.out.print("Enter name of course: ");
		courseName = scan.nextLine();
		System.out.print("Enter ID for course: ");
		courseID = scan.nextLine();
		System.out.print("Enter description for course: ");
		courseDescription = scan.nextLine();
		System.out.print("Enter date for course: ");
		courseDate = scan.nextLine();
		System.out.print("Enter number of students for course: ");
		noOfStudents = scan.nextInt();

		course = new Course(courseName, courseID, courseDescription, courseDate, noOfStudents);
		System.out.println();
		System.out.println("Course successfully created.");

	}

	public void defineTimetable() {
		System.out.println("--Define timetable--");
		
	}
}
