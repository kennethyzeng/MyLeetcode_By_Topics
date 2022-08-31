###########
Dynamic programming:
Time complexity : O(n)
Space complexity: O(n)
#############    
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if height == []:
            return 0

        n = len(height)
        max_left = [0]* n
        max_right = [0]* n
        ##print(max_left, height)
        max_left[0] = 0
        max_right[n-1] = 0
        for i in range (1, n):
            max_left[i] = max(max_left[i - 1], height[i-1])
             
        for i in range(n-2, -1, -1):
           
            max_right[i] = max(max_right[i + 1], height[i + 1])

        output = 0
        print(max_left, max_right)
        
        for i in range(n):
		    
            lower_boundary = min(max_left[i], max_right[i])
            
            max_trap_at_i = lower_boundary - height[i]
            
            if max_trap_at_i > 0:
                output += max_trap_at_i
                
        return output