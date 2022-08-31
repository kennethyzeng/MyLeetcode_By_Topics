/*
23ms

*/ 

class Solution {
    public int findMaximumXOR(int[] nums) {
        
        int max = 0;
        for(int n: nums)
            max = Math.max(max, n);
        
        int result = 0, mask = 0;
        Set<Integer> set = new HashSet();
        for(int i= 31 - Integer.numberOfLeadingZeros(max); i>= 0; i--) {
            set.clear();
            int bit = 1 << i;
            mask |= bit;
            int temp = result | bit;
            for(int n: nums) {
                if(set.contains((n & mask) ^ temp)) {
                    result = temp;
                    break;
                }
                set.add(n & mask);
            }
        }
        return result;
    
        
        
    }
}