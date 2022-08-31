###########
Time Complexity:
Space Complexity:


#############
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        
        pre = strs[0]
        
        for i in strs:
            while not i.startswith(pre):
                pre = pre[:-1]
        
        return pre 
        
        
###################
class Solution:
    def longestCommonPrefix(self, S: List[str]) -> str:
        if not S: return ''
        m, M, i = min(S), max(S), 0
        for i in range(min(len(m),len(M))):
            if m[i] != M[i]: break
        else: i += 1
        return m[:i]
		