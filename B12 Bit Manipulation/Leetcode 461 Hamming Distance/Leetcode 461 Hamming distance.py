###########
Time Complexity:
Space Complexity:


#############
class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        count = 0
		# XOR both the numbers and then simple count the number of set bits in the result.
        x ^= y
        while x:
            if x & 1:
                count += 1
            x >>= 1
        return count
        
 ###############
 