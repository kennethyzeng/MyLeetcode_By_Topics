/*
Time Complexity:
Space Complexity:
https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/discuss/181086/JavaPython-3-two-one-pass-codes-space-O(n)-and-O(1)-respectively

*/ 
//Time & space: O(n).

    public int minAddToMakeValid(String S) {
        Deque<Character> stk = new ArrayDeque<>();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') { 
                stk.push(c); 
            }else if (stk.isEmpty()) { 
                ++count; 
            }else { 
                stk.pop(); 
            }
        }
        return count + stk.size();
    }
----------------
//Time: O(n), space: O(1)
    public int minAddToMakeValid(String S) {
        int count = 0, stk = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') { 
                ++stk; 
            }else if (stk == 0) { 
                ++count; 
            }else {
                --stk; 
            }
        }
        return count + stk;
    }