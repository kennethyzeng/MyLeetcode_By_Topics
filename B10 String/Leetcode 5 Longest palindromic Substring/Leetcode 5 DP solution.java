/*
Time: O(n^2)
Space O(1)

*/ 

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(); 
        String res = null; 
        int start = 0, maxLen = 0; 
        
        boolean[][] dp = new boolean[n][n]; 
        
        for (int i = n -1; i >=0; i--){
            for (int j = n-1; j>= i; j--){
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j-i <3 || dp[i+1][j-1]);
                
                //update max palindrome string
                if(dp[i][j] && (j-i +1 > maxLen)){
                    start = i; 
                    maxLen = j - i +1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}