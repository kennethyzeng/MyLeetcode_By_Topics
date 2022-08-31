class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new LinkedList<>();
        backtrack(0,candidates,new ArrayList<Integer>(), target,output);
    return output;
    }
    private void backtrack(int first, int[] candi, ArrayList<Integer> tempList, int target,List<List<Integer>> output){
        if(target==0){
            output.add(new ArrayList<>(tempList));
            return;
        }
    for(int i=first;i<candi.length;i++){
        if(target-candi[i]>=0){
        tempList.add(candi[i]);
        backtrack(i,candi,tempList,target-candi[i],output);
        tempList.remove(tempList.size()-1);
        }
    }
    }
}