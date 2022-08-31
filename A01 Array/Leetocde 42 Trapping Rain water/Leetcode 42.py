###########
Python Two pointer approach with explanation O(n) time O(1) space
Time complexity O(n)
Space complexity O(1)

Water units trapped in each index of the array is calculated and added individually.
Water level at an index is determined by the lower of max_left and max_right for any bar,i.e. essentially water trapped in bar i depends on min(max_left, right_left).
Water trapped in index i = min(max_left, max_right) - height[i].
Therefore if max_left < max_right, we fill the left index up to max_left, and advance the left pointer; and vice versa. If max_left equals max_right, moving either pointer would work.
#############
class Solution:
    def trap(self, height: List[int]) -> int:
        
        if len(height)<= 2:
            return 0
        
        ans = 0
        
        #using two pointers i and j on indices 1 and n-1
        i = 1
        j = len(height) - 1
        
        #initialising leftmax to the leftmost bar and rightmax to the rightmost bar
        lmax = height[0]
        rmax = height[-1]
        
        while i <=j:
            # check lmax and rmax for current i, j positions
            if height[i] > lmax:
                lmax = height[i]
            if height[j] > rmax:
                rmax = height[j]
            
            #fill water upto lmax level for index i and move i to the right
            if lmax <= rmax:
                ans += lmax - height[i]
                i += 1
				
            #fill water upto rmax level for index j and move j to the left
            else:
                ans += rmax - height[j]
                j -= 1
                
        return ans