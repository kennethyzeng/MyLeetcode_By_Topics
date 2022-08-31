/*

O(n) time complexity
Space O(256)

Fast and slow pointer start from indext 0 of string 
Faster keep moving forward  fast ++; 
Slow won't move until the value at current index > 1 because fast pointer scan one more character which cause >1
*/ 

class Solution {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0) return -1;
        int slow=0,fast=0;
        char[] chs=s.toCharArray();
        int[] count=new int[256];
        int n=chs.length;
        while (fast<n){
            count[chs[fast]]++;
            while (slow<n && count[chs[slow]]>1){
                slow++;
            }
            if (slow==n) return -1;
            fast++;
        }
        return slow;
    }
}