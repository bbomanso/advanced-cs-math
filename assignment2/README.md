# Assignment 2
Write a program that will compute interpolation polynomials for a given data set using Divided Differences (Newton's method).

## Program Requirements
- The program should contain a method (dividedDifferenceTable) that has the following as the parameters:
    1. **Parameters**: *x* and *y* values (both arrays of size *n*) and size *n* as the parameters.
    2. **Return**: a reference to the divided difference table for the data set.
- The program should contain a method (interpolationPolynomial) that has the following as the parameters and then return:
    1. **Parameters**: Divided difference table, x values of the data set, size *n*, and a real number at which an interpolation (or an extrapolation) of the data set is needed.
    2. **Return**: the value of the value of the polynomial at the real number (the last parameter listed)
- The main method will take the data set as input in the following form:
    1. The program will take 3 lines of input.
    2. The **first line** contains *n*, the number of data points.
    3. The **second line** contains *n* double that are the x-coordinates *x1*, *x2*, *x3*, ..., *xn* of the data points separated by single spaces.
    4. The **third line** contains *n* double that are the y-coordinates *y1*, *y2*, *y3*, ..., *yn* of the data points.
- After reading the dataset, the program will repeatedly prompt the user to enter x, a double for an x-coordinate and output the value of the interpolating polynomial.
- The program should terminate if the user enters an empty line.