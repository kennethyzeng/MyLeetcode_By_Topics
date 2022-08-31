/*
Time Complexity:
Space Complexity:

*/ 

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n ; i ++){
            nums[i] = i +1; 
        }
        
        List<List<Integer>> res = new ArrayList<>(); 
        helper(nums, res, new ArrayList<>(), 0, k);         //nums index = 0
        return res; 
    }
    
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, int index, int count){
        //exit case
        if (count == 0){
            res.add(new ArrayList<> (tmp));
            return;
        }
        
        for (int i = index; i < nums.length; i++){
            tmp.add(nums[i]);
            helper(nums, res, tmp, i +1, count - 1);
            tmp.remove(tmp.size() -1);
        }
    } 
    
}
