class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, ans);
        return ans;
    }
    
    
    private void dfs(int[] nums, int begin, List<List<Integer>> ans) {
        if (begin >= nums.length) {
			List<Integer> current = new ArrayList<Integer>();
			for (int a : nums) {
			    current.add(a);
			}
			ans.add(current);
        }
    
    // every number chosen to be the begin once
        for (int i = begin; i < nums.length; ++i) {
            swap(nums, begin, i);
            dfs(nums, begin+1, ans);
            swap(nums, begin, i);
        }
    } 
     private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
}