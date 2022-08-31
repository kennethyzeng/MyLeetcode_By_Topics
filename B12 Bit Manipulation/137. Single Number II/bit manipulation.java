/*
Time Complexity: O(n)
Space Complexity:

*/ 

class Solution {
    public int singleNumber(int[] nums) {
        int counterOne = 0;
        int counterTwo = 0;

        for (int i = 0; i < nums.length; i++){
            counterOne = (~counterTwo) & (counterOne ^ nums[i]);
            counterTwo = (~counterOne) & (counterTwo ^ nums[i]);
        }
        return counterOne;
    
    
    }
}
