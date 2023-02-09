/**
 * Name: Beatriz Ristau
 * Date: February 15, 2022
 * Course: CS 479
 * Assignment: Divided Differences
 * Description: Program computes interpolation polynomials for a given data using Divided Differences (Newton's Method).
*/

package assignment2;

import java.util.Scanner;

public class DividedDifferences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numPoints = sc.nextInt(); // store number of data points
        double[] xCoordinates = new double[numPoints]; // store x coordinate values
        double[] yCoordinates = new double[numPoints]; // store y coordinate values
    
        // get x coordinate values from the user
        for (int i = 0; i < numPoints; i++) {
            xCoordinates[i] = sc.nextDouble();
        }

        // get y coordinate values from the user
        for (int j = 0; j < numPoints; j++) {
            yCoordinates[j] = sc.nextDouble();
        }

        // call method and store the return value
        double[][] resultTable = dividedDifferenceTable(xCoordinates, yCoordinates, numPoints);

        sc.nextLine(); // cleaning scanner

        System.out.println("Hit return to quit or enter a value for x to evaluate the polynomial.");
        String str = sc.nextLine();

        // keep asking user until the user enters an empty line
        while(!(str.isEmpty())) {
            double value = Double.parseDouble(str); // convert input to a double type
            // call method and store the return value
            double result = interpolationPolynomial(resultTable, xCoordinates, numPoints, value); 
            System.out.printf("The value of the polynomial at x = %.1f is %.5f\n", value, result); 
            System.out.println("Hit return to quit or enter a value for x to evaluate the polynomial.");
            str = sc.nextLine();
        }

        sc.close(); // closing resource
    }

    // method to calculate the polynomial interpolation
    private static double interpolationPolynomial(double[][] dividedDiffTable, double[] x, int n, double value) {
        double result = 0;

        // calculating the value of the polynomial
        for(int i = 0; i < n; i++) {
            double product = dividedDiffTable[i][i]; // getting f(xn) from the divided difference table

            for(int j = 0; j < i; j++) {
                product *= (value - x[j]);
            }

            result += product;
        }

        return result; // return the value of the polynomial at the real number
    }

    // method to calculate and create the divided differences tables
    private static double[][] dividedDifferenceTable(double[] x, double[] y, int n) {
        double[][] dividedDiffTable = new double[n][n];

        // store y valyes in first column of table
        for(int i = 0; i < n; i++) {
            dividedDiffTable[i][0] = y[i];
        }

        // calculating the divided differences of a set of data points
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= i; j++) {
                // the divided difference of 2 data points is defined as the difference between their values, divided by the difference between their x-coordinates
                dividedDiffTable[i][j] = (dividedDiffTable[i][j-1] - dividedDiffTable[i-1][j-1]) / (x[i] - x[i-j]);
            }
        }

        return dividedDiffTable; // return reference to the divided difference table for the dataset
    }
}