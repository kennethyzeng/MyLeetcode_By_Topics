/*

Time Complexity: O(N)
Space Complexity: O(1)
*/ 

class Solution {
    public int hammingDistance(int x, int y) {
        int cnt = 0; 
        while(x>0 || y>0){
            cnt += (x%2)^(y%2);
            x >>= 1; 
            y >>= 1;
        }
        return cnt; 
        
    }
}


##########
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x^y;
        int ans = 0;
        while(xor > 0)
        {
            if(xor%2 == 1)
                ans++;
            xor = xor/2;
        }
        return ans;
    }
}