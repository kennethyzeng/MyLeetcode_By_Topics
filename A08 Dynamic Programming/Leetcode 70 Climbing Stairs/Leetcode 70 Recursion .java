/*
Recustion (Top Down Approach)

*/ 

/**
 * Question   : Climbing Stairs
 * Complexity : Time: O(2^n) ; Space: O(n)
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}



########################

/**
 * Question   : Climbing Stairs
 * Complexity : Time: O(n) ; Space: O(n)
 */
class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(1, 1);
        memo.put(2, 2);
        return climbStairs(n, memo);                //climStairs(n, (x,x))
    }

    private int climbStairs(int n, Map<Integer, Integer> memo) {
        //base case here is related to memo input at public 
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, climbStairs(n - 1, memo) + climbStairs(n - 2, memo));           //
        return memo.get(n);
    }
}