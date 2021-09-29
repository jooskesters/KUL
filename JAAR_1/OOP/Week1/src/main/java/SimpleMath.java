import java.io.UncheckedIOException;

public class SimpleMath {

    public SimpleMath() {

    }

    public static double Sum(int x, int y){
        return x + y;
    }

    public static double AverageFromToNumbers(int lowerBound, int upperBound){
        double accumulator = 0;
        double amountOfIterations = upperBound - lowerBound;
        for (int i = lowerBound; i < upperBound; i++) {
            accumulator += i;
        }
        return accumulator / amountOfIterations;
    }


    public static double IterativePower(double base, int power){
        double result = base;
        while (power > 1){
            result *= base;
            power--;
        }
        return result;
    }

    public static double RecursivePower(double base, int power){
        double result = 0;
        if (power > 1){
            result += base * RecursivePower(base, power -1);

        }
        else{ return 1; }

        return result;
    }

    public static double Sqrt(double number) {
        if (number < 0){
            throw new RuntimeException("Can't take square root of negative number");
        }
        else{
            double t;
            double sqrtroot = number/2;
            do{
                t = sqrtroot;
                sqrtroot= (t+(number/t)) / 2;
            }
            while((t-sqrtroot) != 0);
            return sqrtroot;
        }
    }



}
