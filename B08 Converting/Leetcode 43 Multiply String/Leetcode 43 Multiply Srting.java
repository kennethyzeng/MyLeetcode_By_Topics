/*
Time Complexity: O(n* m) because two for loop; bruce force
Space Complexity: O(n*m) because create spce for digits []

*/ 


class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2== null) return "0";
        int[] digits = new int[num1.length() + num2.length()]; 
        for(int i = num1.length()-1; i>=0; i--){
            for (int j = num2.length() -1; j >= 0; j--){
                int product = (num1.charAt(i)-'0') * (num2.charAt(j) - '0'); 
                int p1 = i + j , p2 = i + j + 1;
                int sum = product + digits[p2]; 
                digits[p1] += sum / 10;   
                digits[p2] = sum %10;  //remainer 
            }
        }
        StringBuilder res = new StringBuilder(); 
        //beware case of [0,0,123] ==> 0 is first one of two digits
        for(int digit: digits){
            if(!(digit == 0 & res.length()==0))
                res.append(digit);
        }
        return res.length() ==0? "0" : res.toString();
    }
}