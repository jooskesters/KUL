package intervals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntervalTest {
	
	@Test
	void test() {
		Interval i = new Interval();
		i.setLowerBound(0);
		i.setUpperBound(2);
		
		int width = i.getUpperBound() - i.getLowerBound();
		assert width == 2;
	}

}
