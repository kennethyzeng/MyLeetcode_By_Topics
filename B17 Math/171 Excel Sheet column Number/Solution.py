###########
Time Complexity:
Space Complexity:


#############
class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        res = 0
        for i, v in enumerate (reversed(columnTitle.upper())): 
            res += ( ord(v) - ord('A') + 1) * (26**i)
            
        return res

##########
class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        ans, pos = 0, 0
        for letter in reversed(columnTitle):
            digit = ord(letter)-64
            ans += digit * 26**pos
            pos += 1
            
        return ans