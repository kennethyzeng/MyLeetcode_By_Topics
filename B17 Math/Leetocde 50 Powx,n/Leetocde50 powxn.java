/*
Time Complexity:  O(log n)
Space Complexity: O(1)

*/ 


class Solution {
    public double myPow(double x, int n) {
        boolean isNegative = false; 
        if(n < 0){
            x = 1/x; 
            isNegative = true; 
            n = - (n+1);             //-2^31 <= n <= 2^31-1; when turn n back to positive; it is to avoid ieteger overflow  
        }
        
        double ans = 1; 
        double tmp = x; 
        
        while (n != 0){
            if (n % 2 == 1){
                ans *= tmp;      // ans = ans* tmp
            }
            tmp *= tmp; 
            n /= 2; 
        }
        
        if(isNegative){
            ans *= x;       //because add 1 * x back 
        }
        return ans; 
    }
}