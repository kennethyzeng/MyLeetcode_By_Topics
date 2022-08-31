/*
Time Complexity:
Space Complexity:

*/ 

class Solution {
    public boolean search(int[] nums, int target) {
        //corner case
        if(nums == null || nums.length == 0) return false; 
        
        int l = 0, r = nums.length -1; 
        
        while(l <= r){
            int mid = l + (r -l) /2;
            if (nums[mid] == target)  return true;      //output
            if(nums[mid] == nums[r]) {          //avoid duplicate
                r --; 
            }else if(nums[mid] < nums[r]){
                if(target > nums[mid] && target <= nums[r]){   //detetmind range of target
                    l = mid +1; 
                } else{
                    r = mid -1; 
                }    
                        
            }else {             //nums[mid] >=num[h]
                if(target >= nums[l] && target < nums[mid]){
                    r = mid -1;
                } else {
                    l = mid +1;
                }
                
            }
        }
        return false; 
    }
}
