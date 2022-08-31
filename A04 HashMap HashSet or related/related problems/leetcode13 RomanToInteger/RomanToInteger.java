class Solution {
    public int romanToInt(String s) {
        int result = map(s.charAt(s.length() -1));   //private part; last character
        
        for (int i = s.length() -2 ; i >= 0 ; i--){
            if (map(s.charAt(i)) >= map(s.charAt(i+1))) {     // s.length() -2  > s.length()-1
                result += map(s.charAt(i));                
            } else{
                result -=map(s.charAt(i));
            }
        }
        
        return result;
    }
    
    
    private static int map(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}