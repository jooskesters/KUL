import Entity.Person;
import Entity.Vector;
import Utility.ArrayUtil;
import Utility.PersonUtil;
import Utility.SimpleMath;

import java.lang.reflect.Array;
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
        System.out.println("Utilities.SimpleMath assertions");
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
        // Oefening 1
        // Create person objects
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();
        Person p5 = new Person();

        // Set ages
        p1.setAge(5);
        p2.setAge(6);
        p3.setAge(29);
        p4.setAge(21);
        p5.setAge(19);

        // add siblings
        p4.setNextOldestSibling(p5);
        p3.setNextOldestSibling(p4);
        p2.setNextOldestSibling(p3);
        p1.setNextOldestSibling(p2);

        System.out.println("Iterative person count - p1 has: " + PersonUtil.iterativeSiblingCount(p1) + " siblings");
        System.out.println("Recursive person count - p1 has: " + PersonUtil.recursiveSiblingCount(p1) + " siblings");

        System.out.println("Iterative adult person count - p1 has: " + PersonUtil.iterativeAdultSiblingCount(p1) + " siblings");
        System.out.println("Recursive person count - p1 has: " + PersonUtil.recursiveAdultSiblingCount(p1) + " siblings");


        // Sorting
        // Checks
        Integer[] arr = new Integer[] {78, 34, 1, 3, 90, 34, -1, -4, 6, 55, 20, -65};
        System.out.println("Sorting array in ascending order");
        Integer[] result = ArrayUtil.sortAscending(arr);
        System.out.println("Sorted array: " + Arrays.toString(result));

        // Occurence count
        int[] arr2 = new int[] {5,5,5,5,6,4,5,6,4,5};
        int result2 = ArrayUtil.elementOccurenceCount(arr2, 6);
        System.out.println("Occurence count of the number 6: " + result2);

        // Array is permutation of other array.
        Integer[] arr3 = {2, 1, 3, 5, 4, 3, 2};
        Integer[] arr4 = {3, 2, 2, 4, 5, 3, 1, 8};
        System.out.println("is permutation: " + ArrayUtil.permutationCheck(arr3, arr4));
        System.out.println("is elegantPermutation: " + ArrayUtil.elegantPermutationCheck(arr3, arr4));

        // Is sorted version of other array
        Integer[] arr5 = {1,2,3};
        Integer[] arr6 = {2,1,3};
        //System.out.println("Is sorted version: " + ArrayUtil.isSortedVersion(arr5, arr6));

        // Insert
        Integer[] arr7 = {2,2,3,8,4,6,7};
        System.out.println("Insert in array: " + Arrays.toString(ArrayUtil.insert(arr7, 7, 5)));

        Integer[] arr8 = {2,2,3,8,4,6,7};

        // Insertion sort
        System.out.println("Insertion sort: " + Arrays.toString(ArrayUtil.insertionSort(arr8)));

        Integer[] arr9 = {2,2,3,8,4,6,7};
        //Arrays.toString(ArrayUtil.removeGreatest(arr9, 7));

        System.out.println("Remove greatest element from array: " + Arrays.toString(ArrayUtil.removeGreatest(arr9, 7)));

        // Merge
        Integer[] arr10 = {2,2,2,3,3,3,5,6,8};
        Integer[] arr11 = {4,4,4,5,5,5,6,6,6};
        System.out.println("Merge arrays: " + Arrays.toString(ArrayUtil.merge(arr10, arr11)));

        // Subarray
        Integer[] arr12 = {1,2,3,4,5,6};
        System.out.println("Subarray: " + Arrays.toString(ArrayUtil.subArray(arr12, 2,5)));

        // MergeSort
        Integer[] arr13 = {3,1,2,4,6,5};
        System.out.println("Mergesort: " + Arrays.toString(ArrayUtil.mergeSort(arr13)));
    }
}


