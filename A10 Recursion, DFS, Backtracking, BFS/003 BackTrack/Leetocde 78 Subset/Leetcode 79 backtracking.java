/*
Time Complexity: n* 2^n
Space Complexity:

*/ 
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0) return res; 
        
        Arrays.sort(nums); 
        helper(nums, res, new ArrayList<>(), 0);               //backtracking
        return res; 
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer>tmpList, int index){
        res.add(new ArrayList<>(tmpList));
        
        for (int i = index; i < nums.length; i++){
            tmpList.add(nums[i]);
            helper(nums, res, tmpList, i +1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}

