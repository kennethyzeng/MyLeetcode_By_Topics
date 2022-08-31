/*
Sliding Window

*/ 

class Solution {
    public String minWindow(String s, String t) {
	//forgot corner case, see pyton
	//use one Array map with length 128 to store and count each charcter in target string t	
        int[] map = new int[128];
        for (char c: t.toCharArray()){          /* initialize the hash map here */ 
            map[c]++;
        }
        
        int start =0, end = 0, minStart =0, minLen = Integer.MAX_VALUE, counter = t.length();

        while(end < s.length()){
	    //while counter != 0
            final char c1 = s.charAt(end); 
            if (map[c1] > 0) counter--;                 ///* modify counter here */
            map[c1] --;
            end ++;
		
            while(counter == 0){
                if (minLen > end - start){                  ///* update minLen and locate minStart index location for minium substring*/
                    minLen = end - start; 
                    minStart = start;
                }
//adjust start and mpa[] to adjust and find mimium substring upon current end pt
                final char c2 = s.charAt(start); 	
                map[c2]++;                                  ////increase begin to make it invalid/valid again
                if (map[c2] > 0) counter ++;            /*then start index pass over A, B, C, map[] for it may > 0, then while loop break*/ 
                start ++;
            }
        }
        return minLen == Integer.MAX_VALUE? "" : s.substring(minStart, minStart + minLen);
    }
}
