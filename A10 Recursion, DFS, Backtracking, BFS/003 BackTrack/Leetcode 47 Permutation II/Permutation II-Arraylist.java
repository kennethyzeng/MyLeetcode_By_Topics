class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        //corner case
        if (nums == null || nums.length == 0) return res; 
        
        backtrack(res, nums, new ArrayList<Integer>(), visited); 
        return res;
        
    }
    
    private void backtrack(List<List<Integer>> res, int[] nums,List<Integer> tempList, boolean[] visited){
        
        if (tempList.size() == nums.length){
            res.add(new ArrayList<Integer> (tempList)); 
            return; 
        }
        
        for (int i = 0; i < nums.length; i++){
            if (visited[i]) continue;      //check if visited already. if visited, then continue
            if (i > 0 && nums[i] == nums[i-1] & !visited[i - 1]) continue;
            
            tempList.add(nums[i]); 
            visited[i]= true;      //mark unvisisted 
            backtrack(res, nums, tempList,visited);
            tempList.remove(tempList.size() -1);
            visited[i] = false;      //mark as visted
        }
        
    }
    
}