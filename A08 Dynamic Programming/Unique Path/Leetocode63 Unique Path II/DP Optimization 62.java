/*
Time Complexity: O(mxn)
Space Complexity:  O(m)

*/ 


public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (m == 0 || n == 0) {
        return 0;
    }
    if (m == 1 || n == 1) {
        return 1;
    }

    int width = obstacleGrid[0].length;
    int[] dp = new int[width];
    dp[0] = 1;
    for (int[] row : obstacleGrid) {
        for (int j = 0; j < width; j++) {
            if (row[j] == 1)
                dp[j] = 0;
            else if (j > 0)
                dp[j] += dp[j - 1];
        }
    }
    return dp[width - 1];
}
}
