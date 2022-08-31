//6ms
//

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = 0; 
        int minGap = Integer.MAX_VALUE; 
        Arrays.sort(nums); 
        
        for (int i = 0; i < nums.length -2; i ++){
            int j = i +1; 
            int k = nums.length -1; 
            
            while (j < k){å
                int sum = nums[i] + nums[j] + nums[k]; 
                int gap = Math.abs(sum - target); 
                if(gap < minGap){
                    minGap = gap; 
                    result = sum;
                }
                
                if (sum < target){
                    j++;
                } else{
                    k--;
                }
            }
        }
        return result;
    }

}
