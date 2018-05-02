
public class Timetable {
	
	
	private String courseName, courseID;
	private String[] courseDays, courseTimes;
	
	public Timetable(String courseName, String courseID, String[] courseDays, String[] courseTimes) {
		this.courseName = courseName;
		this.courseID = courseID;
		this.courseDays = courseDays;
		this.courseTimes = courseTimes;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String[] getCourseDays() {
		return courseDays;
	}

	public void setCourseDays(String[] courseDays) {
		this.courseDays = courseDays;
	}

	public String[] getCourseTimes() {
		return courseTimes;
	}

	public void setCourseTimes(String[] courseTimes) {
		this.courseTimes = courseTimes;
	}
	
	
}
