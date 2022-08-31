class Solution {
    public void moveZeroes(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0) return;
   
        int start = 0; 
        for(int i=0; i< nums.length; i++){
            if (nums[i] != 0){
                nums[start] = nums[i]; 
                start ++;
            }
        }


        for (int i = start; i < nums.length; i ++){
            nums[i] = 0;
        }
    }
}


//////////two pointer with swap  (result is better)
    public void moveZeroes(int[] nums) {
        int s = 0, f = 0;
        while (f < nums.length) {
            if (nums[f] == 0) {
                f++;
                continue;
            }
            swap(nums, s, f);
            s++;
            f++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}