/*
Time complexity: O(n) because iteration of whole string
Space complexity O(k) ?? don't count the map?   size should be size of the array


*/ 

class Solution{
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        //corner case
        if (s ==  null || s.length()== 0) return 0;

        int[] map = new int[256];
        int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;

        while (end < s.length()) {
            //right pointer extend condition
            final char c1 = s.charAt(end);
            if (map[c1] == 0) counter++;
            map[c1]++;
            end++;

            //left pointer reduce condition
            if (counter > k){
                maxLen = Math.max(maxLen, end - start);
                while (counter > k) {
                    final char c2 = s.charAt(start);
                    if (map[c2] == 1) counter--;   //counter -- only remove the last character
                    map[c2]--;
                    start++;
                }
            }
            
        }

        return maxLen;
    }
}
