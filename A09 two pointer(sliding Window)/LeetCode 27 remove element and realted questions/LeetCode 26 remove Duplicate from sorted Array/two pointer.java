class Solution {
    public int removeDuplicates(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0) return 0;
        
        Arrays.sort(nums);    //optional since it is sorted array
        int start = 1; 
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[start - 1]){
                nums[start] = nums[i]; 
                start ++;
            }
            
        }
        return start; 
    }
}

#########better and faster
class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}