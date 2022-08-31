/*
O(long n)
Space: O(1)

*/ 


class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1; 
        int peak_index = findPeakIndex(nums); 
        if (peak_index >= 0 && target >= nums[0] && target <= nums[peak_index]){  //
            return binarySearch(nums, 0, peak_index, target);
        }else{
            return binarySearch(nums, peak_index +1, nums.length -1, target);
        }
    }
    
    private int findPeakIndex(int[] nums){
        if (nums.length == 1) return 0;                 //
        if (nums[0] < nums[nums.length -1]) return nums.length -1;    //Ascending order
        int left = 0, right = nums.length -1; 
        while(left <= right){
            int mid = left + (right - left) /2;
            if(nums[mid] > nums[mid +1]) return mid; 
            else if (nums[left] <= nums[mid]){
                left = mid +1; 
            } else{
                right = mid -1;
            }
        }
        return 0; 
    }
    
    private int binarySearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = left + (right - left) /2;
            if(nums[mid]  == target) return mid; 
            else if (nums[mid] >= target){
                right = mid -1; 
            } else{
                left = mid +1;
            }
        }
        return -1; 
    }
}