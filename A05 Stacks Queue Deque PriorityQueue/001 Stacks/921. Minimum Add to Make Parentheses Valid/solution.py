###########
Time Complexity:
Space Complexity:

Time: O(n), space: O(1).
#############
class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        stk = count = 0
        for c in s: 
            if c == '(':
                stk += 1
            else:
                stk -= 1
            
            if stk == -1:
                stk = 0
                count += 1
            
        return stk + count

-------
class Solution(object):
    def minAddToMakeValid(self, S):
        """
        :type S: str
        :rtype: int
        """
        
        while "()" in S:
            S = S.replace("()", "")
        
        return len(S)