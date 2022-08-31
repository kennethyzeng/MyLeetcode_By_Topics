/*
Time Complexity:
Space Complexity:

*/ 

class Solution{    
    void setZeroes(int[][] matrix) {
        boolean isZeroCol = false;
        boolean isZeroRow = false;
    
        int m = matrix.length; 
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) { //check the first column
            if (matrix[i][0] == 0) {
                isZeroCol = true;
                break;
            } 
        }
        for (int i = 0; i < n; i++) { //check the first row
            if (matrix[0][i] == 0) {
                isZeroRow = true;
                break;
            } 
        }
        for (int i = 1; i < m; i++) { //check except the first row and column
            for (int j = 1; j < n; j++) 
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
        }
        for (int i = 1; i < m; i++) { //process except the first row and column
           for (int j = 1; j < n; j++) 
               if (matrix[i][0] == 0 || matrix[0][j] == 0)
                   matrix[i][j] = 0;
        }
        if (isZeroCol) { //handle the first column
            for (int i = 0; i < m; i++) 
                matrix[i][0] = 0;
        }
        if (isZeroRow) { //handle the first row
            for (int i = 0; i < n; i++) 
                matrix[0][i] = 0;
        }
    }
}
