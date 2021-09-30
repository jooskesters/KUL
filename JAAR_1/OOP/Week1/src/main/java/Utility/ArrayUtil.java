package Utility;

import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayUtil {

    public ArrayUtil() {
    }

    public static double ZeroCounter(List<Double> arrayList) {
        int amountOfZeros = 0;
        for (Double var : arrayList) {
            if (var == 0) {
                amountOfZeros++;
            }
        }
        return amountOfZeros;
    }

    public static int[] negationOfElementsArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = -array[i];
        }
        return array;
    }

    public static ArrayList<Double> NegationOfElementsList(List<Double> arrayList) {
        ArrayList<Double> result = new ArrayList<>();
        for (double element : arrayList) {
            System.out.println(element);
            result.add(-element);
        }
        return result;
    }

    public static Integer[] sortAscending(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int temp = 0;
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static Integer elementOccurenceCount(int[] arr, int target) {
        int count = 0;
        for (int element : arr) {
            if (element == target) {
                count++;
            }
        }
        return count;
    }

    public static boolean elegantPermutationCheck(Integer[] arr, Integer[] arr2) {
        if (arr.length == arr2.length) {
            Map<Integer, Long> result = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            Map<Integer, Long> result2 = Arrays.stream(arr2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            if (result.equals(result2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean permutationCheck(Integer[] arr, Integer[] arr2) {
        List<Integer> occurencesArr1 = new ArrayList<>();
        List<Integer> occurencesArr2 = new ArrayList<>();

        // Store all occurences of the numbers in new ArrayLists
        if (arr.length == arr2.length) {
            for (int i = 0; i < arr.length; i++) {
                int currentNumber = arr[i];
                int occurenceCounter = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (currentNumber == arr[j]) {
                        occurenceCounter++;
                    }
                }
                occurencesArr1.add(occurenceCounter);
            }

            for (int i = 0; i < arr2.length; i++) {
                int currentNumber = arr2[i];
                int occurenceCounter = 0;
                for (int j = 0; j < arr2.length; j++) {
                    if (currentNumber == arr2[j]) {
                        occurenceCounter++;
                    }
                }
                occurencesArr2.add(occurenceCounter);
            }
            occurencesArr1 = Arrays.asList(sortAscending(occurencesArr1.toArray(new Integer[0])));
            occurencesArr2 = Arrays.asList(sortAscending(occurencesArr2.toArray(new Integer[0])));
            if (Arrays.equals(occurencesArr1.toArray(), occurencesArr2.toArray())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSortedVersion(Integer[] arr1, Integer[] arr2) {
        System.out.println("kaasje: " + Arrays.compare(arr1, sortAscending(arr2)));
        if (Arrays.compare(sortAscending(arr1), arr2) == 0) {
            return true;
        }
        return false;
    }

    public static Integer[] insert(Integer[] arr, int n, int v) {
        arr = sortAscending(Arrays.copyOfRange(arr, 0, n));

        Integer[] result = new Integer[arr.length + 1];
        int searchIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < v && arr[i + 1] > v) {
                searchIndex = i;
            }
        }

        for (int i = 0; i < searchIndex+1; i++) {
            result[i] = arr[i];
        }
        result[searchIndex+1] = v;
        for (int i = searchIndex + 2; i < result.length; i++) {
            result[i] = arr[i - 1];
        }
        return result;
    }

    // TODO: insertion sort

    public static Integer[] removeGreatest(Integer[] arr, int n){
        arr = Arrays.copyOfRange(arr, 0, n);
        Integer[] result = new Integer[arr.length - 1];

        int indexLargestNumber = 0;
        int largestNumber = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (largestNumber < arr[i]){
                indexLargestNumber = i;
                largestNumber = arr[i];
            }
        }

        // TODO: remove the largestNumber from the sequence
        for (int i = 0; i < arr.length; i++) {
            if (i == indexLargestNumber){
                arr[i] = null;
            }
        }

        for (int i = 0; i < indexLargestNumber; i++) {
            result[i] = arr[i];
        }
        for (int i = indexLargestNumber + 1; i < arr.length; i++) {
            result[i] = arr[i];
        }




        return arr;
    }
}
