###########
Time Complexity:
Space Complexity:


##########################
class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        rows_to_zero = set() # set to keep track rows to make zeros
        cols_to_zero = set() # set to keep track columns to make zeros
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0: # found a zero keep adding row and column to sets
                    rows_to_zero.add(i)
                    cols_to_zero.add(j)
        # in iteration 2 if we find those rows and columns make then zero            
        for i in range(m):
            for j in range(n):
                if i in rows_to_zero:
                    matrix[i][j] = 0
                if j in cols_to_zero:
                    matrix[i][j] = 0

##################################  O(1) Space Solution
class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None: 
        rows, cols = len(matrix), len(matrix[0])
        col0 = False
		
        for row in range(rows):
            col0 = col0 or matrix[row][0] == 0 
            for column in range(1, cols): 
                if matrix[row][column] == 0: 
                    matrix[row][0] = matrix[0][column] = 0   
					
        for row in range(rows-1, -1, -1):
            for column in range(cols-1, 0, -1): 
                if matrix[row][0] == 0 or matrix[0][column] == 0:
                    matrix[row][column] = 0
            matrix[row][0] = 0 if col0 else matrix[row][0]


#############python 2 solution

class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        col0, rows, cols = 1, len(matrix), len(matrix[0])

        for i in xrange(0, rows):
            if matrix[i][0] == 0:
                col0 = 0
            for j in xrange(1, cols):
                if matrix[i][j] == 0:
                    matrix[i][0] = matrix[0][j] = 0

        for i in xrange(rows-1, -1, -1):
            for j in xrange(1, cols):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0
            if col0 == 0:
                matrix[i][0] = 0

        print matrix