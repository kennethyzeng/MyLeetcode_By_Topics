###########
Time Complexity:
Space Complexity:


#############
class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        if not n:
            return []
        if n == 1:
            return [[1]]
        
        ans = [[0]* n for _ in range(n)]
        
        left, right = 0, n-1
        top, bottom = 0, n-1
        
        k = 1
        direction = 0
        
        while left <= right and top <= bottom:
            # from left to right in top row
            if direction == 0:
                for j in range(left, right+1):
                    ans[top][j] = k
                    k += 1
                top += 1
                direction = 1
            elif direction == 1:
                # from top to bottom in right column
                for i in range(top, bottom+1):
                    ans[i][right] = k
                    k += 1
                right -= 1
                direction = 2
            elif direction == 2:
                # from right to left in bottom row
                for j in range(right, left-1, -1):
                    ans[bottom][j] = k
                    k += 1
                bottom -= 1
                direction = 3
            else:
                # bottom to top in left column
                for i in range(bottom, top-1, -1):
                    ans[i][left] = k
                    k += 1
                left += 1
                direction = 0
        return ans

########################
ef generateMatrix(self, n: int) -> List[List[int]]:
	
	k = 0 # current number
    x = 0 # x position 
    y = -1 # y position
    res = [[0 for _ in range(n)] for _ in range(n)] # empty n x n 
    
    # Set these to opposite of what you want it to be
    dx = -1 # direction of x
    dy = -1 # direction of y
    magx = n + 1 # magnitude of x
    magy = n # magnitude of y
    
    while(k < n ** 2):
        # move across horizontally 
        magx -= 1 # decrement
        dx *= -1 # flip direction
        for _ in range(magx):
            k += 1 # increment current value
            y += dx # move horizontally
            res[x][y] = k

        # move across vertically
        magy -= 1 # decrement
        dy *= -1 # flip direction
        for i in range(magy):
            k += 1 # increment current value
            x += dy # move vertically
            res[x][y] = k 
    
    return res