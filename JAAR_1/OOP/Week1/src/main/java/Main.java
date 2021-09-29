import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws AssertionError  {
        // Methods and loops

        // Oefening 1
        assert SimpleMath.Sum(1,2) == 3;
        assert SimpleMath.Sum(3,2) == 5;

        // Oefening 2
        assert SimpleMath.AverageFromToNumbers(1,5) == 3;
        assert SimpleMath.AverageFromToNumbers(2,4) == 3;

        // Oefening 3
        System.out.println("SimpleMath assertions");
        System.out.println("Iterative Power: " + SimpleMath.IterativePower(3,3));
        assert SimpleMath.IterativePower(2,2) == 4;

        System.out.println("Recursive Power: " + SimpleMath.RecursivePower(2,5));
        assert SimpleMath.RecursivePower(2,2) == 4;

        System.out.println("Square root: " + SimpleMath.Sqrt(9));
        assert SimpleMath.Sqrt(9) == 3;

        // Arrays
        // Oefening 1
        List<Double> listOfNumbers = Arrays.asList(0.1,2.0,3.0,4.0,5.0,0.0,0.0,0.0,1.0,2.0,3.0);
        List<Double> listOfNumbers2 = Arrays.asList(0.0,0.0,0.0);

        System.out.println("Count amount of zeros: " + ArrayUtil.ZeroCounter(listOfNumbers2));
        assert ArrayUtil.ZeroCounter(listOfNumbers2) == 3;

        // Oefening 2
        int[] inputArray = new int[]{1,2,3,-1,-2,-3};
        System.out.println("Return negation of each element in array: " + Arrays.toString((ArrayUtil.negationOfElementsArray(inputArray))));

        // Oefening 3
        ArrayList<Double> listOfNumbers3 = new ArrayList<>(Arrays.asList(1.0,2.0,-1.0,-2.0));
        System.out.println("Return negation of each element in list: " + ArrayUtil.NegationOfElementsList(listOfNumbers3));

        // Objects
        // Oefening 2 (Euclidian distance)

        // Create vector
        Vector testVector = new Vector(5, 6);
        Vector testVector2 = new Vector(3,4);

        // Oefening 2 (Size of vectors)
        System.out.println("Return the size of the testVector: " + testVector.getSize());
        System.out.println("Return the size of testVector2: " + testVector2.getSize());

        // Oefening 3 (Compare vector sizes)
        System.out.println("True if vector1 is bigger then vector2 distance: " + testVector.compareVectors(testVector2));

        // Oefening 4 (Create a summed vector from 2 existing vectors)
        Vector summedVector = Vector.createSummedVector(testVector, testVector2);
        System.out.println("summedVector size: " + summedVector.getSize());

        // Oefening 5 (Shift values of existing vector)
        System.out.println("Shifting the values of the testVector");
        testVector.shift(testVector2);

        // Siblings

    }
}


