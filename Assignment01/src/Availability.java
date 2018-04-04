
public class Availability {

	private String availableTime, currentShifts;

	public Availability(String availableTime, String currentShifts) {
		this.availableTime = availableTime;
		this.currentShifts = currentShifts;

	}

	public String getAvailableTime() {
		return this.availableTime;
	}

	public String getCurrentShifts() {
		return this.currentShifts;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public void setCurrentShifts(String currentShifts) {
		this.currentShifts = currentShifts;
	}
	
	
}
