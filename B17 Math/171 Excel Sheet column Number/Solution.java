/*
Time Complexity:
Space Complexity:
https://leetcode.com/problems/excel-sheet-column-number/discuss/52154/Concise-java-solution-with-explanation.

"B" = 2
"BC" = (2)26 + 3
"BCM" = (2(26) + 3)26 + 13
*/ 

public class Solution {
    public int titleToNumber(String s) {
        if (s == null) return -1;
        int sum = 0;
        // for each loop so we don't need to mess with index values.
        for (char c : s.toUpperCase().toCharArray()) {
            sum *= 26;
            sum += c - 'A' + 1;
        }
        return sum;
    }
}
