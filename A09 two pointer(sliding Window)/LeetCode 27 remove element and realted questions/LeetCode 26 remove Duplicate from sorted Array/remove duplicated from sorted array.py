####
input = [0,1,1,1,2,2,3,3,4]
tail                 fast            nums
1                     1      [0, 1, 1, 1, 2, 2, 3, 3, 4]
1                     2      [0, 1, 1, 1, 2, 2, 3, 3, 4]
1                     3      [0, 1, 1, 1, 2, 2, 3, 3, 4]
2                     4      [0, 1, 2, 1, 2, 2, 3, 3, 4]
2                     5      [0, 1, 2, 1, 2, 2, 3, 3, 4]
3                     6      [0, 1, 2, 3, 2, 2, 3, 3, 4]
3                     7      [0, 1, 2, 3, 2, 2, 3, 3, 4]
4                     8      [0, 1, 2, 3, 4, 2, 3, 3, 4]
####



class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        length = 0
        if len(nums) == 0: return length
        for i in range(1,len(nums)):
            if nums[length] < nums[i]:
                length += 1
                nums[length] = nums[i]
        return length+1
