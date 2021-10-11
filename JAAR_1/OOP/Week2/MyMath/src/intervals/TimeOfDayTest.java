package intervals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TimeOfDayTest {

	@Test
	void test() {
		TimeOfDay defaultTod = new TimeOfDay();
		TimeOfDay tod = new TimeOfDay(14, 30);
		
		tod.setHours(11);
		tod.setMinutes(59);
		
		int minutesSinceMidnight = tod.getMinutesSinceMidnigth();
		
		assert defaultTod.getHours() == 0;
		assert defaultTod.getMinutes() == 0;
		assert tod.getHours() == 11;
		assert tod.getMinutes() == 59;
		assert minutesSinceMidnight == 719 && minutesSinceMidnight <= 60 * 24;
		
		// todo change minutes field to minutesSinceMidnight without changing test
	}

}
