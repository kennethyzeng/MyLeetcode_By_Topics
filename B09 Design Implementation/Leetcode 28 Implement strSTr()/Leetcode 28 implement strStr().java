/*
Time Complexity:
Space Complexity:
3ms

*/ 

class Solution {
    public int strStr(String haystack, String needle) {
       int n = haystack.length();
        int m = needle.length();
        
        if (m > n) {
            return -1;
        }
        
        if (m == 0) {
            return 0;
        }
        
        int start = 0;
        int distance = 0;
        
        while (start + distance < n) {
            while (start < n - m && (haystack.charAt(start) != needle.charAt(0) || haystack.charAt(start + m - 1) != needle.charAt(m - 1))) {
                start++;
            }
            
            if (haystack.charAt(start + distance) == needle.charAt(distance)) {
                distance++;
                
                if (distance == m) {
                    return start;
                }
            } else {
                start++;
                distance = 0;
            }
        }
        
        return -1;
    }
}
