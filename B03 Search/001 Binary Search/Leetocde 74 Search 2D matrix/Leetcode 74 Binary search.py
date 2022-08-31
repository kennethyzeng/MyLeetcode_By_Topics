###########
Time Complexity:
Space Complexity:
for m by n matrix, time complexity is O(logm+logn), space complexity is O(m+n).

#############
class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if not matrix or not matrix[0]:
            return False
        
        #finding out row
        for x in range(len(matrix)):
            
            if target == matrix[x][0] or target == matrix[x][-1]:
                return True
            
            elif target > matrix[x][0] and target < matrix[x][-1]:
                # look for element in row
                l, r = 0, len(matrix[x]) - 1
                
                while l <= r:
                    mid = l + (r - l) // 2
                    
                    if target == matrix[x][mid]:
                        return True
                    
                    elif target > matrix[x][mid]:
                        l = mid + 1
                        
                    else:
                        r = mid - 1
                        
                return False