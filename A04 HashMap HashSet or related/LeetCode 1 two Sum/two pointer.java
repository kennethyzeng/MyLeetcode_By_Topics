/*
method 1: use brute force. 
Time Complexity O(N^2) since element is scanned twice 
Space Complexity O(1)
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i ++){
            for (int j = i +1; j < nums.length; j ++){
                if (nums[j] == target - nums[i])
                    return new int[] {i, j};  // [1, 2]
            }
        }
        throw new IllegalArgumentException("No two sum solution");
        
    }
}


/*  Improvement for follow up; add HashMap 
method 2: use HashMAP
Time Complexity O(2N) = O(N) since element is scanned twice 
Space Complexity O(N)

map.containsKey(remain)   O(1)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            map.put(nums[i], i);   //(key, value)
        }
        
        for(int i = 0; i < nums.length; i ++){
            int remain = target - nums[i];
            if (map.containsKey(remain) && map.get(remain) != i){    //conditon: contain key is ture; and key is not itself i
                return new int[] {i, map.get(remain) };
            }
            
        }
        
        throw new IllegalArgumentException("No two sum solution");   
        
    }
}

/*  Improvement for follow up; add one-pass HashMap 
method 3: use HashMAP
Time Complexity O(2N) = O(N) since element is scanned once
Space Complexity O(N)

Inside the for loop, use if and hashmap; so if it is true, return indecies; otherwise, put key, value in hashmap
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i ++){
            int remain = target - nums[i];
            
            if (map.containsKey(remain)){
                return new int[] {i, map.get(remain) };
            }
            map.put(nums[i],i);
            
        }
        
        throw new IllegalArgumentException("No two sum solution");   
        
    }
}