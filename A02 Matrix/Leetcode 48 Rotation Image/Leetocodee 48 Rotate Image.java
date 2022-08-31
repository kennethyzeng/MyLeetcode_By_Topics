/*
Time Complexity:  O(n*m) because two for loop 

Space Complexity: o(1)

*/ 


class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j= i; j < matrix[0].length; j++){           //j = i
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i]; 
                matrix[j][i] = tmp;
                    
            }
        }
                
        for(int i = 0; i < matrix.length; i++){
            for(int j= 0; j < matrix[0].length /2; j++){
                int tmp = matrix[i][j]; 
                matrix[i][j] = matrix[i][matrix[0].length -1-j];     //
                matrix[i][matrix[0].length -1 - j] = tmp; 
            }
        }
    }
}