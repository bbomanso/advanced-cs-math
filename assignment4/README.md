# Assignment 4
Write a program to solve an *n* by *n* tridiagonal system using Gaussian elimination with scaled partial pivoting followed by back substitution.

## Program Requirements
- Call you class TridiagonalSystems.
- The program must contain two static methods:
1. The first method is for Gaussian elimination. Name the method gaussianElimination.
2. The second static method is for back substitution.

#### gaussianElimination method
- The gaussianElimination method will take five input parameters.
- Four of the parameters are arrays.
- The main diagonal, sub diagonal, super diagonal, and constant vector that are double arrays of size *n*, *n* - 1, *n* - 1, and *n*, respectively.
- The fifth parameter is the integer *n*.
- This is a void method that modifies the main diagonal, super diagonal, and the constant vector.
- In addition, if Gaussian elimination fails (ai,i becomes 0 for some i), the method will throw an Exception with an appropriate message.
- Also, at the end of reduction, if an,n becomes 0, the system is singular. In that case the method will throw an Exception with a message.

#### backSubstitution method
- The method will take four parameters.
- The first three are the double arrays: main diagonal, super diagonal, and constant vector of the reduced system that are of size *n*, *n* - 1, and *n*, respectively.
- The fourth parameter is the integer *n*.
- The method will return a reference to the solution, a double array of size *n*.

## Input Format
- First line of input is the integer *n*.
- It will follow 4 lines.
- The first of those lines is the super diafonal of the system that contains *n* - 1 doubles.
- The second is the main diagonal that contains *n* doubles.
- The third is the sub diagonal that contains *n* - 1 doubles.
- The fourth is the constant vector that contains *n* doubles.
- Include just one prompt for the use that says "Enter input as agreed".
