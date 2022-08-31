/*
Time Complexity:
Space Complexity:

*/ 

import java.io.*;
import java.util.*;

class Solution {

    static String[] diffBetweenTwoStrings(String source, String target) {
    // your code goes here
    int[] dict = new int[26];
    #Set<Character> set = HashSet<>();
    String[] res = new LinkedList<>(); 
    for (char cs: source.toCharArray()){
      dict[cs - 'A'] += 1; 
      set.add(source.charAt[i]);
    }
    
    for (char ct: target.toCharArray(){
      dict[ct - 'A'] -= 1; 
    }
    
    int asciiValue = 65;    # 65 for 'A' 
    for(int i = 0; i <26; i++){
        while (dict[i]  > 0 )
        {
          res.add("+" + Character.toString(i + asciiValue));
          dict[i] --;
        } 
        
        while (dict[i] < 0)
        {
          res.add("-" + Character.toString(i + asciiValue));
          dict[i] ++;
        }
        
      if ( dict[i] == 0 && set.contains(Character.toString(i + asciiValue)))
      {
        res.add(Character.toString(i + asciiValue));
      }
      
    }
    return res;  
}

    public static void main(String[] args) {
        String source = "ABCDEFG"; 
        String sarget = "ABDFFGH";
        String[] ans = diffBetweenTwoStrings(String source, String target); 
        for Character i : ans{
        System.out.println(i);
        }
    }
}


#########

