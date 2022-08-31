/*

Time Complexity: O(n)
Space Complexity: O(1) # Because there are only 26 different english letters
*/ 

class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1; 
        
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i ++){
            map[s.charAt(i) -'a'] ++; 
        }
        
        for(int i = 0; i < s.length(); i++){
            if(map[s.charAt(i) -'a'] == 1)
                return i; 
        }
        return -1; 
    }
}
