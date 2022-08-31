/*
Time Complexity: O(logN)
Space Complexity:

*/ 
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int lo = 0; 
        int hi = nums.length -1;


        while(lo <= hi){
                int mid = lo + (hi-lo)/2;
                if(nums[mid] == target){
                    return mid;
                }else if(nums[mid] < target){
                    lo = mid +1; 
                }else{
                    hi = mid -1;
                }
        }
        return lo; 
    }
}

