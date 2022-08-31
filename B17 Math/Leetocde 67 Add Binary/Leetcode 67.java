/*
Time Complexity:
Space Complexity:

*/ 
class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b; 
        if(b == null || b.length() == 0) return a; 
        StringBuilder sb = new StringBuilder();
        
        int m = a.length() -1; 
        int n = b.length() -1;
        int carry = 0;
        while(m >= 0 || n >= 0){
            int num1 = m >= 0 ? (a.charAt(m) - '0') : 0; 
            int num2 = n >=0 ? (b.charAt(n) - '0') : 0;
            
            int sum = num1 + num2 + carry; 
            //sb.append(sum % 2);   //can't append since it append to last index; use insert(0, sum %2)
            sb.insert(0, sum % 2);
            carry = sum /2; 
            m --; 
            n--; 
        }
        
        if(carry != 0){
            //sb.append( carry);
            sb.insert(0, carry);
        }
        
        return sb.toString();
    }
}

