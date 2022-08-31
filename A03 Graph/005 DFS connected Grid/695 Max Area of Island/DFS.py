###########
Time Complexity: O(MN)
Space Complexity:

https://leetcode.com/problems/max-area-of-island/discuss/108541/easy-python
#############
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        
        def dfs(i, j):
            if 0 <= i < m and 0 <= j < n and grid[i][j]:
                grid[i][j] = 0 # mark visited
                return 1 + dfs(i + 1 , j) + dfs(i-1, j) + dfs(i, j + 1) + dfs(i, j -1)
            return 0
        
        area = [dfs(i, j) for i in range(m) for j in range(n) if grid[i][j]]
        return max(area) if area else 0

########
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        ans, n, m = 0, len(grid), len(grid[0])
        def trav(i: int, j: int) -> int:
            if i < 0 or j < 0 or i >= n or j >= m or grid[i][j] == 0: return 0
            grid[i][j] = 0
            return 1 + trav(i-1, j) + trav(i, j-1) + trav(i+1, j) + trav(i, j+1)
        for i, j in product(range(n), range(m)):
            if grid[i][j]: ans = max(ans, trav(i, j))
        return ans