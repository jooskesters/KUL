package intervals;

/**
 * Abstractetoestandsvariant:
 * 
 */
public class TimeOfDay {
	int hours;
	int minutes;
	
	public int getHours() { return this.hours; }
	public int getMinutes() { return this.minutes; }
	public int getMinutesSinceMidnigth() { return (getHours() * 60) + getMinutes(); }

	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
}
