class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //corner case 
        if (nums == null || nums.length < 4) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        //int target = 0;
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length - 3; i ++){
            if (i > 0 && nums[i] == nums[i -1]) continue;    //skip if current and previous are same number
            for (int j = i + 1 ; j < nums.length -2; j++){
                if (j > i +1 && nums[j] == nums[j -1]) continue;  //skip duplicte
                int k = j +1; 
                int l = nums.length - 1; 
            
                while(k < l){
                    if (nums[i] + nums[j] + nums[k] + nums[l] < target){
                        k ++; 
                        while (k < l && nums[k] == nums[k -1]) k++;    //skip duplicates
                    }else if(nums[i] + nums[j] + nums[k] + nums[l] > target){
                        l --; 
                        while (k < l && nums[l] == nums[l+1]) l--;      //skip duplicates
                    
                    }else{
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l])); 
                    
                        k++;                               //continue rest since find all sets
                        l--;
                        while (k < l && nums[k] == nums[k -1]) k++; 
                        while (k < l && nums[l] == nums[l+1]) l--; 
                    }
                }
            }
        }
        return res; 
    }
}



##################