
public class HRSystem {

	public static void main(String[] args) {
		Course course = new Course("SEF", "COSC1111", "Software Engineer", "1/02/2018", 2);
		
		Staff courseCoordinator = new CourseCoordinator("Bill", "e523523", "password123", "RMIT", 441222212, 2, "Departmental", "Course");
		
		Staff casualWorker = new CasualWorker("Jill","e123123","password321","RMIT",22222,4);

		Staff approver = new Approver("Will","e456456","password111","RMIT",222,4);
		
		Staff admin = new Admin("Phil","e789789","password333","RMIT",222344,6);
		
		System.out.println(admin.getName());
		
		
	}

}
