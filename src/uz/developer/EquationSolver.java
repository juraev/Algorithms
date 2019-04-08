package uz.developer;

/**
 * Created by Hiro on 22/09/2017.
 */
public class EquationSolver {

    public static double func(double x) {
        return (Math.exp(x) + Math.log(x) - 10 * x);
    }

    public static void main(String[] args) {
        System.out.println("Equation: e^x + lnx-10x");
        System.out.println("Need to find roots in the segment: [3, 4]");
        double approximation = (float) 0.00001;
        double a = 3;
        double b = 4;
        int i = 0;
        while (Math.abs(func(a)) > approximation) {
            a = a - (b - a) * func(a) / (func(b) - func(a));
            b = b - (a - b) * func(b) / (func(a) - func(b));
        }

        System.out.println(a);
        System.out.println(func(a));
    }
}