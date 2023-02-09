/**
 * Name: Beatriz Ristau
 * Date: March 25, 2022
 * Course: CS 479
 * Assignment: Tridiagonal Systems
 * Description: Program that solves tridiagonal matrices.
 */

package assignment4;

import java.util.Scanner;

public class TridiagonalSystems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter input as agreed: ");
            int n = sc.nextInt();
            double[] superDiagonal = new double[n-1];
            double[] mainDiagonal = new double[n]; 
            double[] subDiagonal = new double[n-1];
            double[] constantVector = new double[n];

            // get input for super diagonal
            for(int i = 0; i < n-1; i++) {
                superDiagonal[i] = sc.nextDouble();
            }

            // get input for main diagonal
            for(int i = 0; i < n; i++) {
                mainDiagonal[i] = sc.nextDouble();
            }

            // get input for sub diagonal
            for (int i = 0; i < subDiagonal.length; i++) {
                subDiagonal[i] = sc.nextDouble();
            }

            // get input for constant vector
            for (int i = 0; i < constantVector.length; i++) {
                constantVector[i] = sc.nextDouble();
            }

            gaussianElimination(n, superDiagonal, mainDiagonal, subDiagonal, constantVector);
            
            double[] solution = backSubstitution(n, superDiagonal, mainDiagonal, constantVector);

            // display output
            for (int i = 0; i < n; i++) {
                System.out.printf("x[%d] = %.4f\n", i, solution[i]);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    // method that performs back substitution
    private static double[] backSubstitution(int n, double[] superDiagonal, double[] mainDiagonal, double[] constantVector) {
        double[] x = new double[n];

        x[n-1] = constantVector[n-1] / mainDiagonal[n-1];

        // back substitution
        for(int i = n - 2; i >= 0; i--) {
            x[i] = (constantVector[i] - (superDiagonal[i] * x[i+1])) / mainDiagonal[i];
        }

        return x;
    }

    // method to perform gauss elimination, and modifies the main diagonal, super diagonal arrays
    private static void gaussianElimination(int n, double[] superDiagonal, double[] mainDiagonal, double[] subDiagonal, double[] constantVector) throws Exception {
        double tol = 0.0000000001;

        // gauss elimination
        for(int i = 1; i < n; i++) {
            mainDiagonal[i] = mainDiagonal[i] - ((subDiagonal[i-1] / mainDiagonal[i-1]) * superDiagonal[i-1]);
            constantVector[i] = constantVector[i] - ((subDiagonal[i-1] / mainDiagonal[i-1])  * constantVector[i-1]);

            if(Math.abs(mainDiagonal[i]) < tol) {
                throw new Exception("Singular System.");
            }
        }
    }
}