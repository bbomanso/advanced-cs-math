# Assignment 3
Write a program to solve an *n* by *n* system using Gaussian elimination with scaled partial pivoting followed by back substitution.

## Program Requirements
- Call your class LinearSystems.
- The program must contain two static methods
1. The first method is for Gaussian elimination with scaled partial pivoting. Name the method gaussianWithPivoting.
2. The second method is for back substitution. Call the method backSubstitution.

#### gaussianWithPivoting method
- input parameter to the method will be an *n* by *n*+1 two-dimensional array (the augmented matrix).
- The method will reduce the given system to a triangular system.
- If the system does not have a unique solution (if the system is singular), the method should determine wheter the system is consistent or inconsistent. In these cases, throw an Exception with appropriate messages.
- If Gaussian elimination fails, the method should throw an Exception with an appropriate message.

#### backSubstitution method
- The only parameter of the method will be an *n* by *n*+1 double array that is the reduced augmented matrix produced by the method described above.
- The method will return the solution to the system, a double array of size *n* that is the solution of the system.