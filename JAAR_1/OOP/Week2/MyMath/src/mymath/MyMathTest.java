package mymath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	@Test 
	void test() {
		assertEquals(3, MyMath.squareRoot(9));
		assertEquals(3, MyMath.squareRoot(10));
		assertEquals(0, MyMath.squareRoot(0));
	}
}
