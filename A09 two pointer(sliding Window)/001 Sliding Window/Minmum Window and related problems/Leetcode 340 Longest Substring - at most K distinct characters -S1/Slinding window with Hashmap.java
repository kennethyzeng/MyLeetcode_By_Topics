/*

Same concept...different way to present
https://www.youtube.com/watch?v=roDQuIVQ3m4

http://buttercola.blogspot.com/2016/06/leetcode-340-longest-substring-with-at.html
*/ 

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
         
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        
	//while map.size <= k, store <key, value> in hashmap
	//fast pointer to extend condition
 
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int freq = map.get(c);
                map.put(c, freq + 1);
            } else {
                map.put(c, 1);
            }
 		//when map.size > k, find update the max len; and slim down the slower pointer            
            if (map.size() > k) {
                maxLen = Math.max(maxLen, i - j);
             
                // Shrink the window size
                while (map.size() > k) {
                    char endC = s.charAt(j);
                    int freq = map.get(endC);
                    if (freq == 1) {
                        map.remove(endC);
                    } else {
                        map.put(endC, freq - 1);
                    }
                    j++;
                }
            }
        }
         
        if (j < s.length()) {
            maxLen = Math.max(maxLen, i - j);
        }
         
        return maxLen;
    }
}

