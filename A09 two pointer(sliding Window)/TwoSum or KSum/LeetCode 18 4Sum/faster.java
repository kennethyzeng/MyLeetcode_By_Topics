class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
		List<List<Integer>> result = new ArrayList<>();
		if( nums == null || n < 4 ) return result;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-3;i++){
			if(i>0 && nums[i]==nums[i-1]) continue;
			for(int j=n-1;j>=i+3;j--){
				if( j < n-1 && nums[j] == nums[j+1] ) continue;			
				int lc=target-nums[i]-nums[j];
                int minTwoSum = nums[i+1] + nums[i+2] ;
                int maxTwoSum = nums[j-2] + nums[j-1] ;
                if ( lc < minTwoSum || lc > maxTwoSum ) continue ; 
				int k=i+1, l=j-1;
				while (k<l){
					if( k > i+1 && nums[k] == nums[k-1] || nums[k] + nums[l] < lc ) k++ ;
					else if( l < j-1 && nums[l] == nums[l+1] || nums[k] + nums[l] > lc ) l-- ;
					else result.add(List.of(nums[i], nums[k++], nums[l--], nums[j]));
				}
			}
		}
		return result;
    }
}