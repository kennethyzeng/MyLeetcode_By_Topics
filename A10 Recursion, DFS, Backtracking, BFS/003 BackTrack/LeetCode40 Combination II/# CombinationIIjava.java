//ex [1, 3, 2, 1]

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (candidates == null || candidates.length == 0){
            return res; 
        }
        
        Arrays.sort(candidates);
        
        List<Integer> tmp = new ArrayList<>();
        helper(res, candidates, tmp, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] candidates,
        List<Integer> tmp, int target, int index) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList(tmp));
            }
            return;
        }

            
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;     //avoid recalculation of same value; like 1
            
            if (candidates[i] > target){                //it stop if next element bigger than remained target value
                break;
            }
            
            tmp.add(candidates[i]);
            helper(res, candidates, tmp, target - candidates[i], i + 1);  //i+1 => next element; 
            tmp.remove(tmp.size() - 1);
        }
    }
}