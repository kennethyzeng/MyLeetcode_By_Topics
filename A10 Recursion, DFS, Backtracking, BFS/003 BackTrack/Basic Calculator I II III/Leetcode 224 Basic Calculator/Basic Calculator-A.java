/*
cur = cur * 10 + (c - '0');     ==> cur represent num; in case, cur is 2 or more digits
whenever, it is non-integer, do the sum action, reset the cur = 0; 

if it is + -, only change the sign; the rest reamin the same; 
if (, do the recursive
if ), do the sum 
*/

class Solution {
    int i = 0;
    public int calculate(String s) {
        int sum = 0;
        int sign = 1;
        int cur = 0;
        
        while (i < s.length()) {
            char c = s.charAt(i++);
            
            if (c >= '0' && c <= '9') {
                cur = cur * 10 + (c - '0');
            } else {
                sum += cur * sign;
                cur = 0;
                if (c == '-') {
                    sign = -1;
                } else if (c == '+') {
                    sign = 1;
                } else if (c == '(') {
                    sum = sum + calculate(s) * sign;
                } else if (c == ')') {
                    return sum;
                }
            }
        }
        return sum + cur * sign;
    }
}