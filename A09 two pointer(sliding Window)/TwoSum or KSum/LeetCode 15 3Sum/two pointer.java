////23 ms

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //corner case 
        if (nums == null || nums.length < 3) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        int target = 0;
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length; i ++){
            if (i > 0 && nums[i] == nums[i -1]) continue;    //skip if current and previous are same number
            
            int j = i +1; 
            int k = nums.length - 1; 
            
            while(j < k){
                if (nums[i] + nums[j] + nums[k] < target){
                    j ++; 
                    while (j < k && nums[j] == nums[j -1]) j++;    //skip duplicates
                }else if(nums[i] + nums[j] + nums[k] > target){
                    k --; 
                    while (j < k && nums[k] == nums[k+1]) k--;      //skip duplicates
                    
                }else{
                    res.add(Arrays.asList(nums[i], nums[j], nums[k])); 
                    
                    j++;                                   //continue rest since find all sets
                    k--;
                    while (j < k && nums[j] == nums[j -1]) j++; 
                    while (j < k && nums[k] == nums[k+1]) k--; 
                }
            }
        }
        return res; 
    }
}


###########14 ms faster
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        List<List<Integer>> ans=new ArrayList();
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0){break;}
           if(i>0 &&nums[i]==nums[i-1] ){continue;}
            int j=i+1;
            int k=nums.length-1;
			int target = -nums[i];
            while(j<k){
                sum=nums[i]+nums[j]+nums[k];
                if(nums[j]+nums[k] < target){j++;}
                else if(nums[j]+nums[k] > target){k--;}
                else{
                    
                    ans.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                   
                       while (j<k && nums[j] == nums[j-1]) j++;
                        while (j<k && nums[k] == nums[k+1]) k--;
                }
               
            }
        }
        return ans;
    }
}