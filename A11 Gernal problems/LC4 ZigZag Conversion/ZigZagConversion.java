/*
Time: O(n)  s.length
Space: O(n)    due to String builder. n is numRows

*/ 

class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows]; 
        for (int i = 0; i < numRows; i ++){
            sbs[i] = new StringBuilder();
        }
        
        int i = 0;
        while(i < s.length()){
            int curRow = 0; 
            //from top to bottom
            while (curRow < numRows && i < s.length()){
                sbs[curRow++].append(s.charAt(i++));
            }
            // now curRow = 3 +1 = 4
            curRow -= 2;    
            //from bottom to top
            while(curRow > 0 && i < s.length()){
                sbs[curRow --].append(s.charAt(i++)); 
            }
        }
        
        //combine all sbs[i]
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < numRows; i++){
            sb.append(sbs[i].toString());
        }
        
        return sb.toString(); 
    }
}
