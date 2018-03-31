
public class Shift {

	private String date, time;
	private int hours;

	public Shift(String date, String time, int hours) {
		this.date = date;
		this.time = time;
		this.hours = hours;
	}

	public String getDate() {
		return this.date;
	}

	public String getTime() {
		return this.time;
	}

	public int getHours() {
		return this.hours;
	}

}
