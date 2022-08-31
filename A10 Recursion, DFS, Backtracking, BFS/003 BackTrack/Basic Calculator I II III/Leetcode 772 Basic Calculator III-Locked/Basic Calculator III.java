/*
其实把所有的计算都看成加法，无非是加正数，加负数的问题。遇到乘除法我们就原地计算成一个新的被加数。遇到括弧就原地递归得出一个新的被加数


*/

public class Solution {
    public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;        //current number
        char sign = '+';     //Previous sign

        for(int i=0;i<len;i++){
            //converte string to digit
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }

            //recursively calculate results in the parentheses 
            if (s.charAt(i) == '('){
                int j = findClosing(s.substring(i));    //String start from index i to )
                num = calculate(s.substring(i+1, i + j));
                i +=j; 
            }

            // in the case of + - * /
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
                
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }


    private int findClosing(STring s){
        int level = 0, i = 0;
        for(i =0; i < s.length(); i ++){
            if (s.charAt(i) == '(') level ++; 
            else if (s.charAt(i) == ')'){
                level --; 
                if(level == 0) break;         
            }else continue; 
        }
        return i; 
    }
}
