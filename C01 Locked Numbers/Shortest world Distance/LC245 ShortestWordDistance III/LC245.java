/*
Time Complexity: O(n)
Space complexity: O(1)
two pointers method
*/ 

public int shortestWordDistance(String[] words, String word1, String word2){
    //initialization 
    int a = -1;
    int b = -1;
    int result = Integer.MAX_VALUE;

    for(int i = 0; i < words.length; i++){
        if (word1.equals(word[i])){         //words[i] == word1  ? okay
            a = i; 
        }
        if (word2.equals(word[i])){
            if(word1.equals(word2){          //
                a = b;                      //
            }
            b = i;
        }

        if(a!= -1 && b = -1){
            result = Math.min(result, Math.abs(a-b));
        }
    }
    return result; 

}
