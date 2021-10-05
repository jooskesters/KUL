package intervals;

/**
 * Abstractetoestandsinvariant:
 * @invar The width equals the difference of the upperBound and the lowerBound.
 * 		| getWidth() == getUpperBound() - getLowerBound()
 * @invar The upperBound is not less than the lowerBound.
 * 		| getLowerBound() <= getUpperBound()
 */
public class Interval {
	/**
	 * Representatie-invariant:
	 * @invar This interval's width is nonnegative.
	 * 		| 0 <= width
	 */
	private int lowerBound;
	private int width;
	
	/**
	 * @post This interval's lowerBound equals zero.
	 * 		| getLowerBound() == 0
	 * @post This interval's upperBound equals zero.
	 * 		| getUpperBound() == 0
	 */
	public Interval() {}
	
	/**
	 * @throws IllegalArgumentException if {@code upperBound} is less than {@code lowerBound}.
	 * 		| lowerBound > upperBound
	 * @pre This interval's given lowerBound is less than the given upperBound.
	 * 		| lowerBound <= upperBound 
	 * @post This interval's lowerBound equals the given lowerBound.
	 * 		| getLowerBound() == lowerBound
	 * @post This interval's upperBound equals the given upperBound.
	 * 		| getUpperBound() == upperBound
	 */
	public Interval(int lowerBound, int upperBound) {
		if(lowerBound > upperBound) {
			throw new IllegalArgumentException("`lowerBound` is greater than `upperBound`");
		}
		this.lowerBound = lowerBound;
		this.width = upperBound - lowerBound;
	}
	
	public int getLowerBound() { return this.lowerBound; }
	public int getUpperBound() { return this.lowerBound + this.width; }
	public int getWidth() { return this.width; }
	
	/**
	 * @pre The given lowerBound is not greater than this interval's upperBound.
	 * 		| lowerBound <= getUpperBound()
	 * @mutates | this
	 * @post This interval's lowerBound equals the given lowerBound.
	 * 		| getLowerBound() == lowerBound
	 * @post This interval's upperBound equals it's old upperBound
	 * 		| getUpperBound() == old(getUpperBound())
	 */
	public void setLowerBound(int lowerBound) {
		this.lowerBound = lowerBound;
	}
	
	/**
	 * @pre The given upperBound is not less than this interval's lowerBound.
	 * 		| getLowerBound() <= upperBound
	 * @mutates | this
	 * @post This interval's upperBound equals the given upperBound.
	 * 		| getUpperBound() == upperBound
	 * @post This interval's lowerBound equals it's old lowerBound
	 * 		| getLowerBound() == old(getLowerBound())
	 */
	public void setUpperBound(int upperBound) {
		this.width = upperBound - this.lowerBound;
	}
	
	/**
	 * @pre The given width is nonnegative.
	 * 		| 0 <= width
	 * @mutates | this
	 * @post This interval's lowerBound equals its old lowerBound.
	 * 		| getLowerBound() == old(getLowerBound()) 
	 * @post This interval's upperBound equals its lowerBound plus the given width.
	 * 		| getUpperBound() == getLowerBound() + width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
}