/*
Time Complexity: O(mxn)
Space Complexity:  O(1)

*/ 

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        //if (m ==0 && n ==0) return grid[m][n]; 
        
        for (int i = 1; i < m ; i ++){
            grid[i][0] += grid[i-1][0];
        }
        
        for(int j=1; j < n; j++){
            grid[0][j] += grid[0][j-1];
        }
        
        for(int j = 1; j < n; j++){
            for(int i = 1; i < m; i++ ){
                grid[i][j] =grid[i][j] + Math.min(grid[i][j-1], grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
        
    }
}