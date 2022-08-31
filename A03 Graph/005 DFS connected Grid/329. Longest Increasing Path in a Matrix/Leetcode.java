/*
Time Complexity: O(MN)
Space Complexity:O(Mn)

*/ 


private int m;
private int n;
private int[][] maxILen;
private int[][] matrix;

public int longestIncreasingPath(int[][] matrix) {
    
    m = matrix.length;
    if(m < 1) return 0;
    n = matrix[0].length;
    this.matrix = matrix;
    
    maxILen = new int[m][n];
    int max = 1;
    
    for(int i=0;i<m;i++){
        
        for(int j=0;j<n;j++){
            max = Math.max(max, maxDFS(i,j));                        
        }
    }
    
    return max;
}

private int maxDFS(int i,int j){
    if(maxILen[i][j] != 0) return maxILen[i][j];
    
    int max = 1;
    if(i+1 < m && matrix[i+1][j] > matrix[i][j]) max = Math.max(max, 1 + maxDFS(i+1,j));
    if(i-1 >= 0 && matrix[i-1][j] > matrix[i][j]) max = Math.max(max, 1 + maxDFS(i-1,j));
    if(j+1 < n && matrix[i][j+1] > matrix[i][j]) max = Math.max(max, 1 + maxDFS(i,j+1));
    if(j-1 >= 0 && matrix[i][j-1] > matrix[i][j]) max = Math.max(max, 1 + maxDFS(i,j-1));
    maxILen[i][j] = max;
    return max;
}