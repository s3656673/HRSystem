
public class CourseCoordinator extends Staff {

	private String school, department, course;

	// Private assignShift()??
	// String name, String rmitID, String password, String school, int phone, int
	// workingHours
	public CourseCoordinator(String name, String rmitID, String password, String school, int phone, int workingHours, String department, String course) {
		super(name,rmitID,password,school,phone,workingHours);
		this.school = school;
		this.department = department;
		this.course = course;
	}

	public String getSchool() {
		return this.school;
	}

	public String getDepartment() {
		return this.department;
	}

	public String getCourse() {
		return this.course;
	}

}
