class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        slow = 0
        for fast in range(len(nums)):
            #condition 1: wait until fast pointer find a non-zerto to swap
            if nums[fast] != 0 and nums[slow] == 0:
                nums[slow], nums[fast] = nums[fast], nums[slow]
            
            #condition 2
            if nums[slow] != 0:
                slow += 1


##########faster 
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        nonzero_idx = 0
        for num in nums:
            if num != 0:
                nums[nonzero_idx] = num
                nonzero_idx += 1
        for idx in range(nonzero_idx, len(nums)):
            nums[idx] = 0