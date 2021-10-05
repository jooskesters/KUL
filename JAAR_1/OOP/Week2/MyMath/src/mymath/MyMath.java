package mymath;

/** procedural abstraction */
public class MyMath {

	/**
	 * Returns the square root, rounded down, of the given nonnegative number.
	 * 
	 * @pre The given number is nonnegative.
	 * 		| 0 <= x
	 * 
	 * @post The square of the result is not greater than the given number.
	 * 		| result * result <= x
	 * 
	 * @post The square of one more than the result is greater than the given number.
	 * 		| x < (result + 1) * (result + 1)
	 */
	public static int squareRoot(int x) {
		int result = 0;
		while((result + 1) * (result + 1) <= x) {
			result++;
		}
		return result;
	}

}
