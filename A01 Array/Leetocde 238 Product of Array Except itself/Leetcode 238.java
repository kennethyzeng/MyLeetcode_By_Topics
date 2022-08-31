/*
Time O(n)
Space O(1)

*/ 


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] res = new int[nums.length]; 
        //left to right
        res[0] = 1;
        for (int i = 1; i < nums.length; i ++){
            res[i] = res[i-1]* nums[i-1];
        }
        //right to left
        int right = 1; 
        for (int i = nums.length -1; i >=0; i--){
            res[i] = res[i] * right; 
            right = right * nums[i];
        }
        return res; 
                    
    }
}