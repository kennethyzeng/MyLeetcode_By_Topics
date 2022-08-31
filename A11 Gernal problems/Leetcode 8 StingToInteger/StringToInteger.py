class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        if len(s) == 0 or (len(s) > 0 and not (s[0] in ['+','-'] or s[0].isdigit())):
            return 0

        value = 0
        sign = -1 if s[0] == '-' else 1
        i = 1 if not s[0].isdigit() else 0

        while i < len(s) and s[i].isdigit():
            value = (value * 10) + (ord(s[i]) - ord('0'))
            i += 1
        value *= sign

        if value < -(2**31):
            return -(2**31)
        elif value > (2**31)-1:
            return (2**31)-1

        return value        

##########
Time complexity: O(n)
Space complexity: O(1)