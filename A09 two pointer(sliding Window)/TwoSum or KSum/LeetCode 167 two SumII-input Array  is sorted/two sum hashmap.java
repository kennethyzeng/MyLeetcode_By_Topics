class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //what is corner case
        
        Map <Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < numbers.length; i ++){
            
            int remain = target - numbers[i];
            
            if (!map.containsKey(remain)){
                map.put(numbers[i], i);
            }else{
                return new int[] { map.get(remain) +1, i + 1};
            }
            
        }
        return null;
    }
}