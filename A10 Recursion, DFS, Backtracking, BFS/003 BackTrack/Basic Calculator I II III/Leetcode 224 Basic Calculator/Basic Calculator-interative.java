/*
O(n) time, O(n) space
My approach is based on the fact that the final arithmetic operation on each number is not only depend on the sign directly operating on it, but all signs associated with each unmatched '(' before that number.

e.g.
5 - ( 6 + ( 4 - 7 ) ), if we remove all parentheses, the expression becomes 5 - 6 - 4 + 7.

sign:

6: (-1)(1) = -1

4: (-1)(1)(1) = -1

7: (-1)(1)(-1) = 1

The effect of associated signs are cumulative, stack is builded based on this. Any improvement is welcome.x

*/

class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>(); 
        int rs = 0;   //result
        int sign = 1; 
        stack.push(1);    //1 is positive, -1 is negative
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' ') continue; 
            else if (s.charAt(i) == '(') {
                stack.push(stack.peekFirst()*sign);
                sign =1;
            }
            else if (s.charAt(i) == ')' ) stack.pop(); 
            else if (s.charAt(i) == '+') sign = 1; 
            else if (s.charAt(i) == '-') sign = -1; 
            else {
                int temp = s.charAt(i) - '0'; 
                while(i +1 < s.length() && Character.isDigit(s.charAt(i+1)))
                    temp = temp * 10 + s.charAt(++i) - '0';
                rs += sign * stack.peekFirst() * temp; 
                    
            }
        }
        return rs; 
    }
    
}