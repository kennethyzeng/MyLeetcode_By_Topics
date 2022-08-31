/*
Time Complexity: O(n)
Space: O(n) because hashset

*/ 


class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxRes = 0, mask = 0; 
        
        for(int i = 31; i >=0; i--){
            mask = mask | (1 << i);  
        
            Set<Integer> set = new HashSet<>(); 
            for (int num : nums){
                set.add(num & mask);
            }

            int temp = maxRes | (1 << i);
            for (int prefix : set){
                if (set.contains(temp ^ prefix)){
                    maxRes = temp; 
                    break;
                }
            }
        }
        return maxRes;
    }
}