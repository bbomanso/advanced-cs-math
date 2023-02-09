package assignment3;

public class LinearSystems {

    // this method will get the scale and ratio vector and it will reduce the matrix
    public static void gaussianWithPivoting(double[][] augmentedMatrix) throws Exception {
        
        // find the scale vector
        double[] scaleVector = getScaleVector(augmentedMatrix); 

        // declaring variables
        double[] ratioVector = new double[augmentedMatrix.length];
        int row = augmentedMatrix.length;
        int col = augmentedMatrix[0].length-1;
        int maxIdx;
        double temp;

        // iterate through each column to find greatest ratio
        for (int j = 0; j < col; j++) { 
            double maxRatio = 0;
            maxIdx = j;
            for (int i = j; i < row; i++) {
                // Calculate ratio
                ratioVector[i] = Math.abs(augmentedMatrix[i][j] / scaleVector[i]);
                if (ratioVector[i] > maxRatio) {
                    maxRatio = ratioVector[i];
                    maxIdx = i;
                }
            }

            if (maxIdx != j) {
                // after the max ratio is found, swap the rows
                for (int k = j; k < augmentedMatrix[0].length; k++) {
                    temp = augmentedMatrix[j][k];
                    augmentedMatrix[j][k] = augmentedMatrix[maxIdx][k];
                    augmentedMatrix[maxIdx][k] = temp;
                }
                // swap the elements in the scale vector as well
                temp = scaleVector[j];
                scaleVector[j] = scaleVector[maxIdx];
                scaleVector[maxIdx] = temp;
            }

            // perform reduction where we make zeros in certain columns
            for(int m = j + 1; m < row; m++) {
                double L = augmentedMatrix[m][j] / augmentedMatrix[j][j];

                for(int n = 0; n < augmentedMatrix[0].length; n++) {
                    augmentedMatrix[m][n] = augmentedMatrix[m][n] - L * augmentedMatrix[j][n];
                }
            }
        }
        backSubstitution(augmentedMatrix);
    }

    // method to find the scale vector
    public static double[] getScaleVector(double[][] matrix) {
        double[] scaleVector = new double[matrix.length];
        double maxValue;

        // iterate through the matrix to find the max value of each row
        for(int i = 0; i < matrix.length; i++) {
            maxValue = -1;
            for(int j = 0; j < matrix[i].length-1; j++) {
                maxValue= Math.max(maxValue, Math.abs(matrix[i][j]));
            }
            // set the scale to max number for next iteration
            scaleVector[i] = maxValue;
        }
        return scaleVector;
    }

    // method to calculate the values of x on each row if they meet certain requirements
    public static double[] backSubstitution(double[][] matrix) throws Exception{

        double solution[] = new double[matrix.length];
        double tol = 0.0000000001;

        if(Math.abs(matrix[matrix.length-1][matrix[0].length-2]) < tol) {
            if(Math.abs(matrix[matrix.length-1][matrix[0].length-1]) < tol) {
                throw new Exception("The System is Singular and Consistent.");
            }
            else {
                throw new Exception("The System is Singular and Inconsistent.");
            }
        }
        // if it passes all requirements then we do the back substitution to find the x values
        else {
            for(int i = matrix.length -1; i>= 0; i--) {
                solution[i] = matrix[i][matrix.length];

                for(int j = i + 1; j < matrix.length; j++) {
                    solution[i] = solution[i] - matrix[i][j] * solution[j];
                }

                solution[i] = solution[i] / matrix[i][i];
            }
        }
        
        return solution; // return the x values 
    }
}