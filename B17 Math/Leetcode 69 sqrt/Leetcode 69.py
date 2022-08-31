###########
Time complexity: O(log(N)).
Space complexity: O(1).

#############
class Solution:
    def mySqrt(self, x: int) -> int:
        
        start = 0
        end = x
        
        while start + 1 < end:
            mid = start + (end - start) // 2
            
            if mid * mid == x:
                return mid
            elif mid * mid < x:
                start = mid
            else:
                end = mid
        
        if end * end == x:
            return end
        
        return start

#########
class Solution:
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """

        # approach: use binary search to find the largest int whose 
        #           square is less or equal than x

        left, right = 0,  x
        while left <= right:
            mid = left + (right - left) // 2

            if mid * mid > x:
                right = mid - 1
            elif mid * mid < x:
                left = mid + 1
            else:
                return mid

        # left > right
        return right