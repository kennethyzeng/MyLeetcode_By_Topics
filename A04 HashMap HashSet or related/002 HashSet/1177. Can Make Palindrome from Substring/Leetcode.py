###########
Time Complexity:
Space Complexity:
https://leetcode.com/problems/can-make-palindrome-from-substring/discuss/371999/Python-100-runtime-and-memory

#############
class Solution:
    def canMakePaliQueries(self, s: str, queries: List[List[int]]) -> List[bool]:
        def canMakePaliQueries(self, s: str, queries: List[List[int]]) -> List[bool]:
            odds = [[False] * 26]
            for i, c in enumerate(s):
                odds.append(odds[i][:])
                odds[i + 1][ord(c) - ord('a')] ^= True   
            #if the number of c is odd => False^True = True since True is 1; 
            #If it even number, then True ^ True => False
            return [sum(odds[hi + 1][i] ^ odds[lo][i] for i in range(26)) // 2 <= k for lo, hi, k in queries] 

#############
  def canMakePaliQueries(s, queries):
      N = 26
      a = ord('a')
      dp = [[0] * N]
      for i in range(1, len(s)+1):
          new = dp[i-1][:]
          j = ord(s[i-1]) - a
          new[j] += 1
          dp.append(new)
      ans = []
      for l, r, k in queries:
          L = dp[l]
          R = dp[r+1]
          ans.append(sum((R[i] - L[i]) & 1 for i in range(N)) // 2 <= k)
      return ans