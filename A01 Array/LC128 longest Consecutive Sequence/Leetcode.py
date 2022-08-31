###########
Time Complexity: O(n)
Space Complexity: O(n)


#############

class Solution:
    def longestConsecutive(self, nums):
        set_nums, ans = set(nums), 0
        for num in nums:
            if num - 1 in set_nums: continue
                
            nxt = num
            while nxt + 1 in set_nums:
                nxt += 1
            ans = max(ans, nxt-num+1)
                
        return ans
++++++++++++++++++
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet= set(nums)
        longest = 0 
        
        for i in numSet:
            if (i -1) is not numSet: 
                length = 0 
                while(i + length ) in numSet:
                    length +=1
                longest = max(longest, length)
        return longest