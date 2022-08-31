/*
Approach: 
Hashmap is to store the character and current index  (char, index)
left: locate the left position of not-repeating string: two conditons: one is last character index  +1 or last left
maxlen:  update max len if i - left +1 > maxlen

Algorith:
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s== null || s.length() == 0) return 0;   //corner case 
        
        Map<Character, Integer> map = new HashMap<>();  //Character is key, index of character is value;
        int maxLen = 1;
        int left = 0;
        
        
        //i is current position; j is new substring Sart position
        for (int i = 0; i < s.length(); i++ ){
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);    //value
            }
            
            if(i -left +1 > maxLen){    // Max = Math.max(Max, i - left + 1);
                maxLen = i - left +1;
            }
            
            map.put(c, i);
           
        } 
        return maxLen;
    }
}

########################################
index:  0	1	2	3 	4	5	6	7
String: a	b 	c 	a	b	c	b	b

i =0 
left = 0			String: a	b 	c 	a	b	c	b	b 
					left
Hashmap : {[a:0]}

------
i =1 
left  = 0 			String: a	b 	c 	a	b	c	b	b 
					left    i
hashmap: {[a:0],[b:1]}
-----
i = 2
left = 0			String: a	b 	c 	a	b	c	b	b 
					left             i
hashmap: {[a:0],[b:1], [c:2}
------
i =3
left =max(0,0+1) = 1			String: a	b 	c 	a	b	c	b	b 
					               left             i
maxlen: i -left +1 = 3  ==>3
hashmap: {[a:3],[b:1], [c:2}

----
i = 4 
left = max(1, 1+1) = 2			String: a	b 	c 	a	b	c	b	b 
					                       left             i
maxlen: i -left +1 = 4- 2 +1 =3	==>3
hashmap: {[a:2],[b:4], [c:2}

------
i = 5 
left = max(2, 2+1)= 3			String: a	b 	c 	a	b	c	b	b 
					                       		left             i
maxlen: i -left +1 = 5- 3 +1 =3	==>3
hashmap: {[a:2],[b:4], [c:5}

-----
i = 6 
left = max(3, 4+1) = 5			String: a	b 	c 	a	b	c	b	b 
					                       			        left    i
maxlen: i - left +1 = 6 -5 +1 = 2   =>3
hashmap: {[a:2],[b:6], [c:5} 

----
i = 7 
left = max(5, b+1) = 7			String: a	b 	c 	a	b	c	b	b 
					                       			                      left&i
maxlen: i - left +1 = 7 -6 +1 = 1  =>3
hashmap: {[a:2],[b:7], [c:5}

----if i=8 is c
 left = max(7, 5+1) = 7			String: a	b 	c 	a	b	c	b	b    c
					                       			                      left   i
maxlen: i - left +1 = 8 -7 +1 = 2  =>3
hashmap: {[a:2],[b:7], [c:8}