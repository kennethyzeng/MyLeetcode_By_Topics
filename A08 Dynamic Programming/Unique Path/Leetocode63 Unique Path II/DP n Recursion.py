###########
Time Complexity:
Space Complexity:


#############
#########recursion with memo
from functools import lru_cache
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        M, N = len(obstacleGrid), len(obstacleGrid[0])
        
        @lru_cache(maxsize=None)
        def dfs(i, j):
            if obstacleGrid[i][j]:      # hit an obstacle
                return 0
            if i == M-1 and j == N-1:   # reach the end
                return 1
            count = 0
            if i < M-1:
                count += dfs(i+1, j)    # go down
            if j < N-1:
                count += dfs(i, j+1)    # go right
            return count
        
        return dfs(0, 0)
        ################

class Solution:
    def uniquePathsWithObstacles(self, OG: List[List[int]]) -> int:
        if OG[0][0]: return 0
        m, n = len(OG), len(OG[0])
        dp = [[0] * n for _ in range(m)]
        dp[0][0] = 1
        for i in range(m):
            for j in range(n):
                if OG[i][j] or (i == 0 and j == 0): continue
                dp[i][j] = (dp[i-1][j] if i else 0) + (dp[i][j-1] if j else 0)
        return dp[m-1][n-1]