/*
Time Complexity:  O(n^2)
Space Complexity:  O(1)

By Leetcode performance, DP is faster
*/ 

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n +1]; 
        dp[0] = 1; 
        
        for(int i = 1; i <=n; i++){
            for (int j = 1; j <= i; j ++){
                dp[i] += dp[j -1]* dp[i -j];
            }
        }
        return dp[n];
    }
}