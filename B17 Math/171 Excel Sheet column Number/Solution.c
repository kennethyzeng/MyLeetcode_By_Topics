/*
Time Complexity:O(n)
Space Complexity:
https://leetcode.com/problems/excel-sheet-column-number/discuss/1790101/C%2B%2B-oror-4-Lines-oror-Easy-To-UnderStand-oror-0ms-oror-100

"B" = 2
"BC" = (2)26 + 3
"BCM" = (2(26) + 3)26 + 13
*/ C++


class Solution {
public:
    int titleToNumber(string columnTitle) {
        int result = 0;
        for(char c : columnTitle)
        {
			//d = s[i](char) - 'A' + 1 (we used  s[i] -  'A' to convert the letter to a number like it's going to be C)

            int d = c - 'A' + 1;
            result = result * 26 + d;
        }
        return result;
    }
};