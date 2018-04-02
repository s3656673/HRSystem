
public abstract class Staff {

	private String name, rmitID, password, school;
	private int phone;
	private int workingHours;


	public Staff(String name, String rmitID, String password, String school, int phone, int workingHours) {
		this.name = name;
		this.rmitID = rmitID;
		this.password = password;
		this.school = school;
		this.phone = phone;
		this.workingHours = workingHours;

	}

	public String getName() {
		return this.name;
	}

	public String getRmitID() {
		return this.rmitID;
	}

	public String getPassword() {
		return this.password;
	}

	public String getSchool() {
		return this.school;
	}

	public int getPhone() {
		return this.phone;
	}

	public int getWorkingHours() {
		return this.workingHours;
	}

	public abstract void menu();


}
