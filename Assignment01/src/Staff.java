
public abstract class Staff {

	private String rmitID, type, firstName, lastName, password, school, phone, workingHours;

	public Staff(String rmitID, String type, String firstName, String lastName, String password, String school,
			String phone, String workingHours) {

		this.rmitID = rmitID;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.school = school;
		this.phone = phone;
		this.workingHours = workingHours;

	}

	public String getRmitID() {
		return rmitID;
	}

	public String getType() {
		return type;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getSchool() {
		return school;
	}

	public String getPhone() {
		return phone;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public abstract void menu();

}
