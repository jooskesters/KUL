package intervals;

/**
 * Abstractetoestandsvariant:
 * @invar The value for hours go from 0 to 23.
 * 		| getHours() >= 0 && getHours() < 24
 * @invar The value for minutes go from 0 to 59.
 * 		| getMinutes() >= 0 && getMinutes() < 60
 * @invar The value of minutesSinceMidnight is the result of the sum between the hours expressed in minutes and the remaining minutes.
 * 		| getMinutesSinceMidnigth() == (60 * getHours()) + getMinutes()
 * @invar The maximum value for minutesSinceMidnight is 1440.
 * 		| getMinutesSinceMidnigth() >= 0 && getMinutesSinceMidnigth() <= (24 * 60)
 */
public class TimeOfDay {
	/**
	 * Representatie-invariant:
	 * @invar The value of this TimeOfDay's hours go from 0 to 23.
	 * 		| hours >= 0 && hours < 24
	 * @invar The value of this TimeOfDay's minutes go from 0 to 59.
	 * 		| minutes >= 0 && minutes < 60  
	 */
	private int hours;
	private int minutes;
	
	/**
	 * @post This TimeOfDay's hours equals zero.
	 * 		| getHours() == 0
	 * @post This TimeOfDay's minutes equals zero.
	 * 		| getMinutes() == 0
	 */
	public TimeOfDay() {}
	
	/**
	 * @pre | hours >= 0 && hours < 24
	 * @pre | minutes >= 0 && minutes < 60
	 * @post | getHours() == hours
	 * @post | getMinutes() == minutes
	 */
	public TimeOfDay(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}
	
	public int getHours() { return this.hours; }
	public int getMinutes() { return this.minutes; }
	public int getMinutesSinceMidnigth() { return (getHours() * 60) + getMinutes(); }
	
	/**
	 * @pre | hours >= 0 && hours < 24
	 * @mutates | this
	 * @post | getHours() == hours
	 * @post | getMinutes() == old(getMinutes())
	 */
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	/**
	 * @pre | minutes >= 0 && minutes < 60
	 * @mutates | this
	 * @post | getMinutes() == minutes
	 * @post | getHours() == old(getHours())
	 */
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
}
