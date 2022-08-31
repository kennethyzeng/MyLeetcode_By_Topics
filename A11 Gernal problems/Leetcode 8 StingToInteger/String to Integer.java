/*
Atoi ==> Ascii to Integer

Step 1: first remove the white space at the both end of string; 
Step 2: corner case 
Step 3: check if the first character is + or -; if neither, don't need to idx ++; it is still at first index
step 4: iteration 
    validate pre-character and /or post-character codition
                if(!Character.isDigit(s.charAt(i))){
                return (int) sum * sign; 
            }
    otherwise, it is character, so read it
            sum = sum * 10 + s.charAt(i) - '0';
    check the range of the digital
*/ 


class Solution {
    public int myAtoi(String s) {
        s = s.trim();    
        if(s == null || s.length() ==0) return 0;
        
        int idx =0;
        int sign = 1;
        char c = s.charAt(0);
        if (c =='+'){
            sign =1; 
            idx ++;
        }else if (c == '-'){
            sign = -1; 
            idx  ++;
        }
        
        
        long sum = 0; 
        for (int i = idx; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                return (int) sum * sign; 
            }
            sum = sum * 10 + s.charAt(i) - '0';
            
            if (sum > Integer.MAX_VALUE && sign == 1){
                return Integer.MAX_VALUE;
            }
            if ((-1)* sum < Integer.MIN_VALUE && sign == -1){
                return Integer.MIN_VALUE;
            }
        }
        return (int)(sum * sign);
        
    }
}