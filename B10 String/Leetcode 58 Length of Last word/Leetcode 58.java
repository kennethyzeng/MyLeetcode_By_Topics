/*
Time Complexity:
Space Complexity:

*/ 
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() ==0) return 0;
        
        int i = s.length() -1;
        while (i >= 0 && s.charAt(i) == ' '){
            i--;
        }
                
        int count = 0; 
        while(i >=0 && s.charAt(i) != ' '){
            i--;
            count ++;
        }
        return count; 
    }
}

