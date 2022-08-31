/*
Corresponding to graph 1; 

List is store all subsets; 
templist is subset,  is append all element to form a subset, then add to list
nums is input array; 
start is start index
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(); 
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0); 
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i ++){     ### i is represent the level 
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i+1);
            tempList.remove(tempList.size() -1);
        }
    }   
    
}


######better to understand 
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>(); 
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0); 
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start){
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i ++){     ### i is represent the level 
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i+1);
            tempList.remove(tempList.size() -1);
        }
    }   
    
}