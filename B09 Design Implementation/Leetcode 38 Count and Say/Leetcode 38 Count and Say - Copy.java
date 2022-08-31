/*
Time Complexity:
Space Complexity:

*/ 
class Solution {
    public String countAndSay(int n) {
        if(n == 1)
        {
            return "1";
        }
        
        String prev = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        char[] p = prev.toCharArray();
        
        for(int i=0; i<p.length; i++)
        {
            int count = 0;
            int index = i;
            
            while(i < p.length && p[i] == p[index])
            {
                i++;
                count++;
            }
            i--;
            sb.append(count);
            sb.append(p[index]);
        }
        return sb.toString();
    }
    

}