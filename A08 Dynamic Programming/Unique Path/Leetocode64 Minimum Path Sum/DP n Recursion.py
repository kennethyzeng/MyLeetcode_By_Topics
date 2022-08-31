###########
Time Complexity:
Space Complexity:


#############
#########Time: O(m*n)
Space: O(1)
class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        for i in range(1, len(grid)):
            grid[i][0] += grid[i-1][0]
        
        for j in range(1, len(grid[0])):
            grid[0][j] += grid[0][j-1]
        
        for i in range(1, len(grid)):
            for j in range(1, len(grid[0])):
                grid[i][j] += min(grid[i-1][j], grid[i][j-1])
                
        return grid[-1][-1]


##################
class Solution:
    # @param {integer[][]} grid
    # @return {integer}
    def minPathSum(self, grid):
        if not len(grid) or not len(grid[0]):
            return 0

        m, n, cache = len(grid) - 1, len(grid[0]) - 1, {}

        return self.findMinSum(grid, m, n, cache)

    def findMinSum(self, grid, m, n, cache):
        if (m, n) in cache:
            return cache[(m, n)]
        elif m < 0 or n < 0:
            return float('inf')
        elif m == 0 and n == 0:
            return grid[0][0]
        else:
            cache[(m, n)] = grid[m][n] + min(self.findMinSum(grid, m - 1, n, cache), self.findMinSum(grid, m, n - 1, cache))

            return cache[(m, n)]