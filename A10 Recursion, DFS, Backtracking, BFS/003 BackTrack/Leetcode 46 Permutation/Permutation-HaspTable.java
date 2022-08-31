public List<List<Integer>> permute(int[] nums) {
   List<List<Integer>> list = new ArrayList<>();
   // Arrays.sort(nums); // not necessary
   backtrack(list, new ArrayList<>(), nums);
   return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
   if(tempList.size() == nums.length){
      list.add(new ArrayList<>(tempList));
   } else{
      for(int i = 0; i < nums.length; i++){ 
         if(tempList.contains(nums[i])) continue; // element already exists, skip
         tempList.add(nums[i]);
         backtrack(list, tempList, nums);
         tempList.remove(tempList.size() - 1);
      }
   }
} 

########fast code
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) {
            return res;
        }
        
        dfs(nums, res, new ArrayList<>());
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list) {
        
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        
        for(int i=0;i<nums.length;i++) {
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(nums, res, list);
            list.remove(list.size()-1);
        }
    } 
}