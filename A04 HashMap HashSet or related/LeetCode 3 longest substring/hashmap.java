/*
method 1: use brute force. 
Time Complexity O(N^2) since element is scanned twice 
Space Complexity O(1)

the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, and keep two pointers which define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap. If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers can only move forward.
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


//
Determine whether two of the numbers add up to x, without using Hash Table

Solution: Two Pointers

Time Complexity: $$O(nlogn)$$

class Solution {
public:
    bool twoSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int left = 0, right = nums.size()-1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return true;
            else if (sum < target) ++left;
            else --right;
        }
        return false;
    }
};