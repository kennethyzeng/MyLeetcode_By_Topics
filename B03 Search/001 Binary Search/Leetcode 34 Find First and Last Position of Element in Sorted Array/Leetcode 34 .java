class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0) return res;
        int lo = 0; 
        int hi = nums.length -1;
      
        
        while(nums[lo] < nums[hi]){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] < target){
                lo = mid +1; 
            }else if(nums[mid] >target){
                hi = mid -1; 
            }else{
                int i = mid-1;
                while(nums[i] == target){
                    i--;
                }
                res[0] =i +1; 
                
                int j = mid +1; 
                while(nums[j] == target){
                    j ++; 
                }
                res[1] = j -1;
                
            }
        }
        return res;       
    }
    
}