package assignment1;

import java.util.function.DoubleUnaryOperator;

/**
 * Name: Beatriz Ristau
 * Date: February 1, 2022
 * Course: CS 479
 * Assignment: Bisection Method
 * Description: Program that finds the root of a function that is trappend in the interval [a,b] using the Bisection Method
*/

public class BisectionMethod {
    public static void main(String[] args) {
        System.out.println("\n--------------------- Bisection Method Algorithm ---------------------\n");
        // creating the functions and calling the method using lambda expressions
        double result1 = bisection(0.0, 1.0, 0.00001, (x) -> x - Math.cos(x));
        double result2 = bisection(0.0, 1.0, 0.00001, (x) -> Math.pow(x,5) - 3*Math.pow(x,4) + 4*Math.pow(x,3) - 1);
        double result3 = bisection(1.0, 3.0, 0.00000001, (x) -> Math.pow(x, 2) - 3);

        // displays results
        System.out.printf("1. cos(x) = x in the interval [0,1] --> root = %.5f\n\n", result1);
        System.out.printf("2. x^5 - 3x^4 + 4x^3 - 1 = 0 in the interval [0,1] --> root = %.5f\n\n", result2);
        System.out.printf("3. sqrt(3) --> root = %.8f\n\n", result3);
        System.out.println("----------------------------------------------------------------------");
    }

    // method that finds the zero of a given function that is trapped in the interval [a,b] to a given accuracy Bisection
    private static double bisection(double a, double b, double tol, DoubleUnaryOperator func) {
        double m = 0; // variable that will hold the midpoint value

        // Find the minimim number of iterations
        int n = (int)(Math.ceil(((Math.log((b - a) / tol)) / Math.log(2))));

        // loop that will run according to the number of iterations found
        for(int i = 0; i < n; i++) {
            m = (a + b) / 2; // get middle point between a and b
            
            // if we solve the function with the value of m and we get 0, then that means that m is the root of the solution
            if(func.applyAsDouble(m) == 0) {
                break;
            }
            // if the 2 points have different signs then replace b with m
            else if(func.applyAsDouble(m) * func.applyAsDouble(a) < 0) {
                b = m;
            }
            // if the 2 points have same signs the replace a with m
            else if(func.applyAsDouble(m) * func.applyAsDouble(a) > 0) {
                a = m;
            }
        }
        return m; // return the root
    }
}