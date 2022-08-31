###########
Time Complexity:
Space Complexity:


#############
#########recursion with memo
class Solution:
    # @param {integer} m
    # @param {integer} n
    # @return {integer}
    def uniquePaths(self, m, n):
        cache = {}
        return self.findPath(m, n, cache)

    def findPath(self, m, n, cache):
        if (m, n) in cache:
            return cache[(m, n)]
        elif m == 1 or n == 1:
            return 1

        cache[(m, n)] = self.findPath(m - 1, n, cache) + self.findPath(m, n - 1, cache)

        return cache[(m, n)]

        ################

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp = [[1]*m for _ in range(n)]
        
        for i in range(1,n):
            for j in range(1,m):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
                
        return dp[-1][-1]