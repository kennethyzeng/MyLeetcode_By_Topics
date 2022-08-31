/*
Time complexity: O(log(N)).
Space complexity: O(1).

*/ 


class Solution {
    public int mySqrt(int x) {
        //corner case
        if(x == 0 || x ==1) return x; 
        
        long start = 1; 
        long end = x; 
        
        while(start <= end){
            long mid = start + (end - start) / 2; 
            
            if (mid * mid == x){
                return (int)mid; 
            }else if(mid*mid > x){
                end = mid -1;
            }else{
                start = mid +1;
            }
            
        }
        
        if(end *end <= x){
            return (int)end; 
        }else{
            return (int)start; 
        }
        
    } 
}