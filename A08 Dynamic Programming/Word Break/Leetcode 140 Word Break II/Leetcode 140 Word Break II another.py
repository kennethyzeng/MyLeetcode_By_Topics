###########
Time Complexity:
Space Complexity:

Python DFS solution O(mn*n) running time
#############
class Solution(object):
    def wordBreak(self, s, wordDict):
        return self.dfs(s, set(wordDict), {})
    
    def dfs(self, s, d, m):
        if s in m: # memorize
            return m[s]
        if not s:
            return [""]
        res = []
        for i in range(1, len(s)+1):
            if s[:i] in d:
                for word in self.dfs(s[i:], d, m):
                    res.append(s[:i] + (" " if word else "") + word)
        m[s] = res
        return res
    
    def wordBreak1(self, s, wordDict):
        res = []
        self.dfs(s, set(wordDict), "", res)
        return res
    
    def dfs1(self, s, dic, path, res):
        if self.check(s, dic):
            if not s:
                res.append(path[1:])
            for i in range(1, len(s)+1):
                if s[:i] in d:
                    self.dfs(s[i:], dic, path+" "+s[:i], res)
                
    def check(self, s, dic):
        dp = [False] * (1+len(s))
        dp[0] = True
        for j in range(1, len(s)+1):
            for i in range(j):
                if dp[i] and s[i:j] in dic:
                    dp[j] = True
                    break
        return dp[-1]