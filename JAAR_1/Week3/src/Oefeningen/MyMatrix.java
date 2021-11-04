package Oefeningen;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 
 * Abstractetoestandsvariant
 * @invar The value of getMatrix != null
 * 		| getMatrix() != null
 *
 *
 */
public class MyMatrix {
	/**
	 * Represenatie-invarianten:
	 * @invar | matrix != null
	 * @invar | Arrays.stream(matrix).allMatch(e -> e != null)
	 * @representationObject
	 */
	
	private double[][] matrix;
	
	/**
	 * 
	 * @pre | matrix != null
	 * @pre | matrix[0].length > 0
	 * @pre | matrix.length > 0
	 * @post | getRowCount() == matrix.length
	 * @post | getColumnCount() == matrix[0].length
	 * @post | IntStream.range(0, getRowCount()).allMatch(i
	 * 		 | -> IntStream.range(0, getColumnCount()).allMatch(j ->  getMatrix()[i][j] == matrix[i][j]))
	 */
	public MyMatrix(double[][] matrix) { 
		double[][] temp = matrix.clone();
		for(int i = 0; i <= temp.length; i++) {
			temp[i] = temp[i].clone();
		}
		this.matrix = temp;
	}
	
	public double[][] getMatrix(){
		return this.matrix.clone();
	}
	
	/**
	 * 
	 * @pre | other != null
	 * @pre | other.length == this.getRowCount()
	 * @pre | other[0].length == this.getColumnCount()
	 */
	public double[][] add(double[][] other){
		double[][] result = new double[matrix.length][matrix[0].length];
		for(int i = 0; i <= matrix.length; i++) {
			for (int j = 0; j <= matrix[i].length; j++) {
				result[i][j] = matrix[i][j] + other[i][j];
			}
		}
		return result;
	}
	

	/**
	 * @post | result >= 0
	 */
	public int getRowCount() {
		int counter = 0;
		for(int i = 0; i < this.matrix.length; i++) {
			counter ++;
		}
		return counter;
	}
	
	/**
	 * @post | result >= 0
	 */
	public int getColumnCount() {
		int counter = 0;
		for (int i = 0; i < this.matrix[0].length; i++) {
			counter++;
		}
		return counter;
	}
	
	
	/**
	 * @pre | scalar >= 0
	 */
	public double[][] scaled(int scalar){
		double[][] temp = this.matrix.clone();
		for(int i = 0; i <= temp.length; i++) {
			temp[i] = temp[i].clone();
		}
		
		for (int i = 0; i <= temp.length; i++) {
			for (int j = 0; j <= temp[i].length; j++) {
				temp[i][j] = scalar * temp[i][j];
			}
		}
		return temp;
	}
	
	/**
	 * 
	 * @param row
	 * @param column
	 * @pre | 0 <= row &&  row <= getRowCount()
	 * @pre | 0 <= column && column <= getColumnCount()
	 */
	public double getElementAt(int row, int column) {
		return this.matrix.clone()[row][column];
	}
}
