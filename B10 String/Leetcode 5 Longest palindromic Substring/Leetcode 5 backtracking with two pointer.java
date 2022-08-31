/*
Time: O(n^2)
Space O(1)

*/ 


class Solution {
    int maxLen = 0; 
    int left = 0; 
    
    public String longestPalindrome(String s) {
        if(s == null || s.length() <=1 ) return s; 
        for(int i = 0; i < s.length(); i++){
            helper(s, i , i);       // case1:   xxabaxx
            helper(s, i, i+1);      //case2:  xxabbaxx
        }
        
        return s. substring(left, left + maxLen);
        
    }
    
    private void helper(String s, int l, int r){
        while (l>= 0 && r <s.length()&& s.charAt(l) == s.charAt(r)){
            if(r-l + 1> maxLen){
                left = l; 
                maxLen = r - l +1;
            }
            
            l--; 
            r ++;
        }
    }
}