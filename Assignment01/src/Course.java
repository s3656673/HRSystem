
public class Course {

	// Declare Variables
	@SuppressWarnings("unused")
	private String name, ID, description, date;
	@SuppressWarnings("unused")
	private int noOfStudents;

	public Course(String name, String ID, String description, String date, int noOfStudents) {
		this.name = name;
		this.ID = ID;
		this.description = description;
		this.date = date;
		this.noOfStudents = noOfStudents;
		
	}
	
	public String getName()
	{
		return this.name;
	}

	public String getID()
	{
		return this.ID;
	}

	public String getDescription()
	{
		return this.description;
	}
	
	public String getdate()
	{
		return this.date;
	}

	public int getNoOfStudents()
	{
		return this.noOfStudents;
	}

	
	
	
}
