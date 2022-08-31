/*
Time Complexity:
Space Complexity:
TC: O(N^2) | SC: O(1)
*/ 


class Solution {
    public int[][] generateMatrix(int n) {
       int[][] matrix = new int[n][n]; 
        if(n ==0){
            return matrix; 
        }
        
        int rowBegin = 0; 
        int rowEnd = n -1; 
        int colBegin = 0; 
        int colEnd = n -1; 
        int num = 1; 
        
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i = colBegin; i <=colEnd; i++){
                matrix[rowBegin][i]= num++;
            }
            rowBegin ++; 
            
            for(int i = rowBegin; i <= rowEnd; i++){
                matrix[i][colEnd] = num++; 
            }
            colEnd--;
            
            for (int i = colEnd; i >=colBegin; i --){
                matrix[rowEnd][i] = num++;
            }
            rowEnd--; 
            
            for(int i = rowEnd; i >=rowBegin; i--){
                matrix[i][colBegin] = num++;
            }
            colBegin++;
            
        }
        return matrix; 
    }
}

#########################
class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        int dir = 0;

        while (top <= bottom && left <= right) {
            switch (dir) {
                case 0: // Left
                    for (int i = left; i <= right; i++) {
                        result[top][i] = num++;
                    }
                    top++;
                    break;
                case 1: // Down
                    for (int i = top; i <= bottom; i++) {
                        result[i][right] = num++;
                    }
                    right--;
                    break;
                case 2: // Right
                    for (int i = right; i >= left; i--) {
                        result[bottom][i] = num++;
                    }
                    bottom--;
                    break;
                case 3: // Up
                    for (int i = bottom; i >= top; i--) {
                        result[i][left] = num++;
                    }
                    left++;
            }
            dir = (dir + 1) % 4;
        }

        return result;
    }
}