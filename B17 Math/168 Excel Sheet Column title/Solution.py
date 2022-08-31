###########
Time Complexity:
Space Complexity:

Now we can see that ABCD＝A×26³＋B×26²＋C×26¹＋D＝1×26³＋2×26²＋3×26¹＋4
https://leetcode.com/problems/excel-sheet-column-title/discuss/51404/Python-solution-with-explanation

#############

class Solution:
    def convertToTitle(self, columnNumber: int) -> str:
        res = [ ]
        while columnNumber > 0:
            letter = chr((columnNumber-1) % 26 + ord('A'))
            res.append(letter)
            columnNumber = (columnNumber-1) // 26
            
        return ''.join(reversed(res))