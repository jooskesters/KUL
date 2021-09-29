package Utility;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {

    public ArrayUtil() {
    }

    public static double ZeroCounter(List<Double> arrayList){
        int amountOfZeros = 0;
        for (Double var : arrayList) {
            if (var == 0){
                amountOfZeros++;
            }
        }
        return amountOfZeros;
    }

    public static int[] negationOfElementsArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = -array[i];
        }
        return array;
    }

    public static ArrayList<Double> NegationOfElementsList(List<Double> arrayList){
        ArrayList<Double> result = new ArrayList<>();
        for (double element : arrayList) {
            System.out.println(element);
            result.add(-element);
        }
        return result;
    }
}
