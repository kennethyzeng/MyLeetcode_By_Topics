/*
Time: O(log10(x))
Space O(1)
*/ 

//revert whole number
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false; 
        int temp = x;
        long sum = 0; 
        
        while (x != 0){
            sum = sum * 10 + x % 10; 
            x /= 10;
        }
        
        return (int) sum ==temp;
        
    }
}

//revert half number
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false; 
        long sum = 0; 
        
        while (x > sum){
            sum = sum * 10 + x % 10; 
            if (sum == x || sum == x/10) return true;
            x /= 10;
        }
        
        return false
        
    }
}