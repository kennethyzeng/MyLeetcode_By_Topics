###########
Time Complexity:
Space Complexity:


#############
Iterative BFS 

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        from collections import deque
   		q = deque([s])
		seen = set() 
		while q:
            s = q.popleft()    # popleft() = BFS ; pop() = DFS
            for word in wordDict:
                if s.startswith(word):
                    new_s = s[len(word):]
					if new_s == "": 
                        return True
                    if new_s not in seen:
                        q.append(new_s)
                        seen.add(new_s)
        return False


###################DP solution
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: bool
        """
        dp = [False] * (len(s) + 1) # dp[i] means s[:i+1] can be segmented into words in the wordDicts 
        dp[0] = True
        for i in range(len(s)):
            for j in range(i, len(s)):
                if dp[i] and s[i: j+1] in wordDict:
                    dp[j+1] = True
                    
        return dp[-1]


#############
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:

        substr_breakable_dict = {}
        
        
        if len(set(s)) > len(set( ''.join(wordDict) ) ):
            return False
        

        def helper(idx):
            
            if idx == len(s):
                return True
            
            
            if idx in substr_breakable_dict:
                return substr_breakable_dict[idx]
            
            
            breakable = False
            for prefix in wordDict:
                
                if s[idx:].startswith(prefix):
                    
                    if helper( idx+len(prefix) ):
                        breakable = True
                        break
                
            substr_breakable_dict[idx] = breakable
            return breakable
 
        return helper(idx=0)