# Assignment 1

Write a program that will solve equations using Bisection method.

## Program Requirements
- The program should contain a method (call it bisection) that finds the zero of a given function that is trapped in the interval [a,b] to a given accuracy using Bisection algorithm.
- The method will take parameters for a, b, required accuracy (tolerance), and a DoubleUnaryOperator type for "the function".
- The bisection method should use a for loop. That means you have to calculate the number of iterations using the tolerance.
- The program should solve the following problems by calling the bisection method using Lambda expressionS:
    1. Find the solution of cos(𝑥)=𝑥 in the interval [0,1] correct to 5 decimal places.
    2. Find the solution of 𝑥5−3𝑥4+4𝑥3−1=0 in the interval [0,1] correct to 5 decimal places.
    3. Find the √3 correct to 8 decimal places.