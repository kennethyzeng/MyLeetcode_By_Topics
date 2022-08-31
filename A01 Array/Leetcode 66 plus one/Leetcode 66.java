/*
Time Complexity:
Space Complexity:

*/ 

class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length -1; 
        for(int i = len; i >= 0; i--){
           if(digits[i] != 9){      //condiiton <9
                digits[i] += 1;
                break;
            }else{
                digits[i] = 0;      //condition 9
           }        
        }
            
        //case 99 +1 = 100
        if(digits[0] == 0){
            int[]res = new int[digits.length +1];
            res[0] = 1; 
            return res;
        }
        return digits; 
    }
}


#################
public int[] plusOne(int[] digits) {
        
    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        
        digits[i] = 0;      //case =9
    }
    
    //conodition when i < 0å
    int[] newNumber = new int [n+1];
    newNumber[0] = 1;
    
    return newNumber;
}
