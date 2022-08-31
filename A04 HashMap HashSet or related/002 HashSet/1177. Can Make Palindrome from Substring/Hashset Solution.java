/*
Time Complexity:
Space Complexity:
https://www.youtube.com/watch?v=kzieK4JJtc0
https://leetcode.com/problems/can-make-palindrome-from-substring/discuss/371888/Java-Easy-to-understand-Beat-100-time-100-space
*/ 


class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList();
        
        for (int[] query : queries) {
            res.add(canMakePal(s, query[0], query[1], query[2]));
        }
        
        return res;
    }
    
    private boolean canMakePal(String s, int start, int end, int max) {
        if (max >= 13) return true;
        Set<Character> set = new HashSet();
        for (int i = start; i <= end; i++) {
            if (!set.add(s.charAt(i))) set.remove(s.charAt(i));
        }
        return max >= set.size()/2;
    }
}


########
    public List<Boolean> canMakePaliQueries(String s, int[][] qs) {
        int[] cnt = new int[s.length() + 1];
        int i = 0;
        for (char c : s.toCharArray()) {
            cnt[i + 1] = cnt[i++] ^ (1 << (c - 'a'));
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] q : qs) {
            int sum = (q[1] - q[0]) % 2;
            sum += Integer.bitCount(cnt[q[1] + 1] ^ cnt[q[0]]);
            res.add(sum / 2 <= q[2]);  // if odd, just put it in center;
        }
        return res;
    }