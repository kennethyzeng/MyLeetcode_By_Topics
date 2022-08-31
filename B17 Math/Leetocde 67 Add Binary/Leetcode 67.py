###########
Time Complexity:
Space Complexity:


#############
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        i, j = len(a), len(b)
        ans, carry = [], 0
        while i or j or carry: 
            if i: carry += int(a[(i := i-1)])
            if j: carry += int(b[(j := j-1)])
            carry, d = divmod(carry, 2)
            ans.append(d)
        return "".join(map(str, reversed(ans)))



#########
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        return f'{int(a, base=2) + int(b, base=2):b}'