import java.util.*;

public class CreateCourse {


	// Declare variables for creating a course
	private String courseName, courseDescription;
	private String courseID;
	private int noOfStudents;

	// Declare variables for defining a timetable
	String courseDays;
	String[] courseDaysArray;
	String[] courseTimes;
	Course course;

	public void createCourse() {
		Scanner scan = new Scanner(System.in);
		// Create a course
		System.out.println("--Create course--");
		System.out.print("Enter name of course: ");
		courseName = scan.nextLine();
		System.out.print("Enter ID for course: ");
		courseID = scan.nextLine();
		System.out.print("Enter description for course: ");
		courseDescription = scan.nextLine();
		System.out.print("Enter number of students for course: ");
		noOfStudents = scan.nextInt();

		course = new Course(courseName, courseID, courseDescription, noOfStudents);
		course.createCourse();
		System.out.println();
		System.out.println("Course successfully created.");

	}

}
