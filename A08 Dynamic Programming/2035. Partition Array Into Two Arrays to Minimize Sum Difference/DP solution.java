/*
Time Complexity:
Space Complexity:
DP solution, but test case didn't work for negative number [-36, 36]
https://www.youtube.com/watch?v=FB0KUhsxXGY
*/ 

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length; 
        int sum = 0; 
        
        for (int num : nums){
            sum += num;
        }
        
        //fill the dynamic table
        boolean[][] dp = new boolean [n+1][sum +1];  
        //boolean[][] dp = new boolean [n+1][sum/2 +1]; //work better?
        for(int i = 0; i <= n ; i++){
            for (int j = 0; j <= sum; j++){
                //for (int j = 0; j <= sum/2; j++){
                if (j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                } else if(nums[i -1] > j){
                    dp[i][j] = dp[i-1][j]; 
                } else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j- nums[i -1]];
                }
            }
        }
        
        //find min difference value 
        int diff = Integer.MAX_VALUE;
        for(int i =0; i <= sum/2; i++){
            int first = i; 
            int second = sum - i; 
            
            if (dp[n][i] == true  &&diff > Math.abs(first - second) ){
               // if (first > 0){
                diff = Math.abs(first - second);
               // } else{
                 //   diff = Math.abs(second - first);
                //}
            }
        }
        return diff; 
    }
}