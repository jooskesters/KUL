package Oefeningen;

import org.junit.Test;
public class MyMatrixTest {

	@Test
	public void test() {
		double[][] m1data = new double[][] {{1, 2, 3}, {4, 5, 6}};
		double[][] m2data = new double[][] {{7, 8, 9}, {10, 11, 12}};
		MyMatrix m1 = new MyMatrix(m1data);
		MyMatrix m2 = new MyMatrix(m2data);
		
		System.out.println("matrix multiple: " + m1.scaled(3));
		System.out.println("matrix addition: " + m1.add(m2data).toString());
	}
}
