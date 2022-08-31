###
#Python O(n^2) time, O(1) space two-pointers solution


class Solution:
    def threeSumClosest(self, nums: List[int], target: int) -> int:

        diff = float('inf')
        a, b, c = -1, -1, -1
        nums.sort()
        n = len(nums)
        for i in range(n):
            start, end = i+1, n-1
            while start < end:
                s = nums[i] + nums[start] + nums[end]
                if abs(s-target) < diff:
                    diff = abs(s-target)
                    a, b, c = i, start, end
                if s < target:
                    start += 1
                else:
                    end -= 1
            if diff ==0:
                return nums[a]+nums[b]+nums[c]
        return nums[a]+nums[b]+nums[c]