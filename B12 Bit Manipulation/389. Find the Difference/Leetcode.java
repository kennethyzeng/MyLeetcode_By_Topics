/*
Time Complexity:
Space Complexity:
https://leetcode.com/problems/find-the-difference/discuss/1751380/JavaC%2B%2BPython-very-very-EASY-to-go-solution
*/ 
##use array 
class Solution {
    public char findTheDifference(String s, String t) {
        int f[] = new int[26];
        for(char c : s.toCharArray())
            f[c - 'a']--;
        for(char c : t.toCharArray())
            f[c - 'a']++;
        int i = 0;
        for(; i < 26; i++)
            if(f[i] == 1) break;
        return (char)(i + 'a');
    }
}

======
use hashmap 
class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(char c : t.toCharArray()){
            if(map.containsKey(c) && map.get(c) == 0 || !map.containsKey(c)) return c;
            else map.put(c, map.get(c) - 1);
        }
        return '!';
    }
}

########
class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
        for(int i = 0; i < s.length(); i++){
            c ^= s.charAt(i);
        }
        for(int i = 0; i < t.length(); i++){
            c ^= t.charAt(i);
        }
        return c;
    }
}


