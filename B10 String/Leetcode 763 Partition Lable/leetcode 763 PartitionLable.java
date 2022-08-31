/*
Java 2 pass O(n) time O(1) space, extending end pointer solution


Approach: 
two pointers: start to located the start of string; last to located the end of substring
Array map: to store and locate the last index of each character
last: is to ientify last position of character which it already traveled so far

index:   0   1    2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19 20  21  22   23
String : a   b    a   b   c   b   a   c   a   d   e   f   e   g   d   e   h   i   j   h  k   l   i   j

1. first iteration: use array map to store the last occurrency of each character
ex: map[a] = 8  map[b]= 5 map[c] = 7

2. seoncd interation: when passed each character, update longest index for the characters which pass through so far==> last
3. generate one result. then start pointer move to last+1 index; 

Algorithm: 
1. use for one for loop and array map to store and indentity the last occurrency of each character
2. at the another for loop; use two pointers to indentify the beginning and ending of the substring. 
3. update one result to list String res. and continue to find next one
*/ 

###########################################
class Solution {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() ==0) return null;  
        
        List<Integer> res = new ArrayList<>();
        int[] map = new int[26]; 			// record the last index of the each char
        for (int i = 0; i < s.length(); i++){
            map[s.charAt(i) - 'a'] = i; 
        }
        // record the end index of the current sub string 
        int start = 0, last= 0; 
        for (int i = 0; i < s.length(); i++){
            last = Math.max(last, map[s.charAt(i)-'a'] ); 
            if(last == i){
                res.add(last- start +1);
                start = last +1;
            }
        }
        return res; 
    }
}
