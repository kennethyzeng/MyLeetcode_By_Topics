/*
Time Complexity:
Space Complexity:
My idea is simple: store states of each row in the first of that row, and store states of each column in the first of that column.
 Because the state of row0 and the state of column0 would occupy the same cell, I let it be the state of row0, and use another variable "col0" for column0. 
 In the first phase, use matrix elements to set states in a top-down way. In the second phase, use states to set matrix elements in a bottom-up way.
*/ 


class Solution {
    public void setZeroes(int[][] matrix) {
        int col0=1;
        int row=matrix.length;
        int col=matrix[0].length;
        
        for (int i=0;i<row;i++){
            if (matrix[i][0]==0) col0=0;
            for (int j=1;j<col;j++){
                if (matrix[i][j]==0){     
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            } 
        }
        for (int i=row-1;i>=0;i--){
            for (int j=col-1;j>=1;j--){
                if (matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0; 
                }
            }
            if (col0 == 0) matrix[i][0] = 0;
        }  
    }
}