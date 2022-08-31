/*
Time O(n)
S O(1)

*/ 

class Solution {
    public void sortColors(int[] nums) {
        //corner case 
        if(nums == null || nums.length == 0) return; 
        
        int Zero = -1; 
        int Two = nums.length; 
        int i = 0; 
        while(i < Two){
            if(nums[i] == 1){
                i++; 
            }else if(nums[i] == 2){
                Two--; 
                swap(nums, i, Two); 
            }else{          //nums[i] ==0
                Zero ++; 
                swap(nums, i, Zero); 
                i++;
            }
        }
    }
    
    private void swap(int [] nums, int a, int b){
        int temp = nums[a]; 
        nums[a] = nums[b]; 
        nums[b] = temp; 
        
    }
}
