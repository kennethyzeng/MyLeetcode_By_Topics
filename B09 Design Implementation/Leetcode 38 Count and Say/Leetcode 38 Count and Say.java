/*
Time Complexity:
Space Complexity:

*/ 


class Solution {
    public String countAndSay(int n) {
        String say = "1"; 
        
        for(int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;
            
            char start = say.charAt(0);
            for(int j = 0; j < say.length(); j++){      //base on say.length
                char c = say.charAt(j);
                if (c == start){            //conditon 1: same
                    count ++;
                }else{
                    sb.append(count).append(start);
                    start = say.charAt(j); 
                    count = 1; 
                    
                }                   
            }
            sb.append(count).append(start);
            say = sb.toString();
            
        }
        return say; 
    }
}