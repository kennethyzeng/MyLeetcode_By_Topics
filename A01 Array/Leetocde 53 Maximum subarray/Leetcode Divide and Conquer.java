/*
Time Complexity:  O(n)
Space Complexity:O(n)

*/ 

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums== null || nums.length == 0) return 0;
        return helper(nums, 0, nums.length -1); 
    }
    
    private int helper(int[]nums, int i, int j){
        if(i == j ) return nums[i];
        
        int mid = (i +j)/2; 
        int sum = 0, leftMax = Integer.MIN_VALUE; 
        
        for(int l = mid; l >= i; l--){
            sum += nums[l];
            if (sum > leftMax){
                leftMax = sum; 
            }
        }
        
        sum = 0;    //reset to 0
        int rightMax = Integer.MIN_VALUE; 
        for(int r = mid +1; r <=j; r++ ){
            sum += nums[r]; 
            if(sum > rightMax){
                rightMax = sum;  
            }
        }
        
        int leftRightMax = Math.max(helper(nums, i, mid), helper(nums, mid+1, j)); 
        return Math.max(leftRightMax, leftMax + rightMax);      //leftMax + rightMax   ==> maxSum subaaray lies about middle of array
    } 
}
