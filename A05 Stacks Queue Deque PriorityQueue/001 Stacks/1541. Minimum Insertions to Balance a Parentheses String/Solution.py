###########
Time Complexity:
Space Complexity:


#############
class Solution:
    def minInsertions(self, s: str) -> int:
        stk = []
        ans = 0

        for c in s:
            if c == '(': 
                if not stk or stk[-1] ==2:
                    stk.append(2)
                else:
                    stk.pop()
                    stk.append(2)
                    ans+=1
            else:
                if not stk:
                    stk.append(1)
                    ans+=1
                elif stk[-1]==1:
                    stk.pop()
                elif stk[-1]==2:
                    stk.pop()
                    stk.append(1)
        ans+= sum(stk)
        return ans