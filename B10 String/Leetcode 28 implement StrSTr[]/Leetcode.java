/*
Time Complexity:
Space Complexity:
this may cause time limited concern. better to ask how long the string is before you use this method
if the string is huge long. it is not a good way to solve

79 / 80 test cases passed.

*/ 


class Solution {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0; 
        if (haystack == null || haystack.length() < needle.length()) return -1; 
        
        for(int i = 0 ; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                int len = 0; 
                while(i+ len < haystack.length() && len < needle.length() && haystack.charAt(i+ len) == needle.charAt(len)){
                    len ++;   
                }
                if (len == needle.length()) return i; 
            }
            
        }
        return -1; 
        
    }
}