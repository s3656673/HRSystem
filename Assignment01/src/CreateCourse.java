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

	public void defineTimetable() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("--Define timetable--");
		System.out.println("Defining timetable for course: " + course.getName());
		System.out.print("Please specify days for the course (e.g. Monday Tuesday Thursday)");
		courseDays = scan.nextLine();
		courseDaysArray = courseDays.split("\\s+");
		courseTimes = new String[courseDaysArray.length];
		
		
		for (int i=0; i<courseDaysArray.length; i++) {
			System.out.print("Please specify time for " + courseDaysArray[i] + ": ");
			courseTimes[i] = scan.nextLine();
		}

		
		
		Timetable timetable = new Timetable(courseName, courseID, courseDaysArray, courseTimes);
		
		for (int i=0; i<courseTimes.length; i++) {
			System.out.println("Day: " + courseDaysArray[i] + " " + "Time: " + courseTimes[i]);
		}
		


	}
}
