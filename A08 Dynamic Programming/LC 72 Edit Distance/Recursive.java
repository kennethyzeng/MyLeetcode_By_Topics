/*
Time Complexity: O(mn)
Space Complexity:
https://leetcode.com/problems/edit-distance/discuss/25895/Step-by-step-explanation-of-how-to-optimize-the-solution-from-simple-recursion-to-DP
*/ 

public class Solution {
    /**
     * Recursive solution.
     * For each poisition, check three subproblem:
     * 1. insert
     * 2. delete
     * 3. replace
     * We only modify the first string since no matter which one we choose, the result is the same. 
     * Got TLE since we recursively solve the same subproblem several times.
     * Appromixately O(len1 ^ 3) time in the worst case.
     * Need to optimize it using cache, which is the idea of dynamic programming. 
     * The key point is to find out the subproblem we have solved duplicately and cache the recursion.
     * Noticed that each subproblem is specificed by i and j pointer, so we can cache the result of these subproblems. 
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();
        
        return match(word1, word2, 0, 0);
    }
    
    private int match(String s1, String s2, int i, int j) {
        //If one of the string's pointer have reached the end of it
        if (s1.length() == i) {
            return s2.length() - j;
        }
        if (s2.length() == j) {
            return s1.length() - i;
        }
        
        int res;
        //If current poisition is the same.
        if (s1.charAt(i) == s2.charAt(j)) {
            res = match(s1, s2, i + 1, j + 1);
        } else {
            //Case1: insert
            int insert = match(s1, s2, i, j + 1);
            //Case2: delete
            int delete = match(s1, s2, i + 1, j);
            //Case3: replace
            int replace = match(s1, s2, i + 1, j + 1);
            res = Math.min(Math.min(insert, delete), replace) + 1;
        }
        
        return res;
    }
}  
This got TLE. based on the analysis above, we may try DP.

public class Solution {
    /**
     * Optimization using dynamic programming
     * Top-down solution
     * O(len1 * len2) time, O(len1 * len2) space
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return -1;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        
        int[][] cache = new int[c1.length][c2.length];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                cache[i][j] = -1;
            }
        }
        
        return match(c1, c2, 0, 0, cache);
    }
    
    private int match(char[] c1, char[] c2, int i, int j, int[][] cache) {
        if (c1.length == i) return c2.length - j;
        if (c2.length == j) return c1.length - i;
        
        if (cache[i][j] != -1) {
            return cache[i][j];
        }
        
        if (c1[i] == c2[j]) {
            cache[i][j] = match(c1, c2, i + 1, j + 1, cache);
        } else {
            //Case1: insert
            int insert = match(c1, c2, i, j + 1, cache);
            //Case2: delete
            int delete = match(c1, c2, i + 1, j, cache);
            //Case3: replace
            int replace = match(c1, c2, i + 1, j + 1, cache);
            
            cache[i][j] = Math.min(Math.min(insert, delete), replace) + 1;
        }
        
        return cache[i][j];
    }
    
    
    
    
    /**
     * Bottom-up approach
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return -1;
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        
        int[][] matched = new int[c1.length + 1][c2.length + 1];
        //matched[length of c1 already been matched][length of c2 already been matched]
        
        for (int i = 0; i <= c1.length; i++) {
            matched[i][0] = i;
        }
        for (int j = 0; j <= c2.length; j++) {
            matched[0][j] = j;
        }
        
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if (c1[i] == c2[j]) {
                    matched[i + 1][j + 1] = matched[i][j];
                } else {
                    matched[i + 1][j + 1] = Math.min(Math.min(matched[i][j + 1], matched[i + 1][j]), matched[i][j]) + 1;
                    //Since it is bottom up, we are considering in the ascending order of indexes.
                    //Insert means plus 1 to j, delete means plus 1 to i, replace means plus 1 to both i and j. 
                    //above sequence is delete, insert and replace. 
                }
            }
        }
        
        return matched[c1.length][c2.length];
    }
    
}