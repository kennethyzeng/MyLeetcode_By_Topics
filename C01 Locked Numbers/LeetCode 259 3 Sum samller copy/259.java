class Solution(object):
    def threeSumSmaller(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if len(nums) < 3:
            return 0

        sums = 0
        nums.sort()
        for i in range(len(nums) - 2):
            sums += self.__twoSumSmaller(nums[i+1:], target - nums[i])

        return sums

    def __twoSumSmaller(self, nums, target):
        sums = 0
        left, right = 0, len(nums) - 1
        while left < right:
            if nums[left] + nums[right] < target:
                sums += right - left
                left += 1
            else:
                right -= 1

        return sums