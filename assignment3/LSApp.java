package assignment3;

import java.util.Scanner;

public class LSApp {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int x;
        do {
            x = menu();
            process(x);
        
        } while(x >= 1 && x <= 4);
    }

    private static int menu() {
        System.out.println("Enter choice 1, 2, 3, 4, or 5:\n" +
        "(1) Problem 1\n" +
        "(2) Problem 2\n" +
        "(3) problem 3\n" +
        "(4) A new problem\n" +
        "(5) Exit");

        return sc.nextInt();    
    }

    private static void process(int x) {
        try {
            switch(x) {
                case 1:
                    double[][] matrix1 = {{2,3,-1,4}, {3,4,1,1}, {4,-1,-2,8}};
                    LinearSystems.gaussianWithPivoting(matrix1);
                    printSolution(LinearSystems.backSubstitution(matrix1));
                    break;
                case 2:
                    double[][] matrix2 = {{2,3,-1,1,-4}, {5,6,-2,0,5}, {-1,4,1,1,1}, {4,-1,-2,-2,8}};
                    LinearSystems.gaussianWithPivoting(matrix2);
                    printSolution(LinearSystems.backSubstitution(matrix2));
                    break;
                case 3:
                    double[][] matrix3 = {{2,-1,3,-1,4,5}, {-1,-3,0,-3,-1,-2}, {1,-1,1,-1,1,7}, {3,-4,3,-6,2,0}, {1,-2,7,-1,4,5}};
                    LinearSystems.gaussianWithPivoting(matrix3);
                    printSolution(LinearSystems.backSubstitution(matrix3));
                    break;
                case 4:
                    double[][] a4 = getData();
                    LinearSystems.gaussianWithPivoting(a4);
                    printSolution(LinearSystems.backSubstitution(a4));
                    break;
                default:
                    System.out.println("Bye!"); 
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    private static void printSolution(double[] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            System.out.printf("x[%d] = %.4f %n",(i+1), matrix[i]);
        }
        System.out.println();
    }

    private static double[][] getData() {
        System.out.println("Enter the data \"as agreed\":");
        int n = sc.nextInt();
        double[][] arr = new double[n][n+1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= n; j++) {
                arr[i][j] = sc.nextDouble();
            }
        }
        return arr;
    }
}