###########
Time Complexity:
Space Complexity:

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums: return 0
        if len(nums) ==1: return nums[0]
        
        max_dp = [0] * len(nums)
        min_dp = [0] * len(nums)
        
        max_dp[0], min_dp[0] = nums[0], nums[0]
        
        for i in range(1, len(nums)):
            max_dp[i] = max(max_dp[i-1] * nums[i], min_dp[i-1] * nums[i], nums[i])
            min_dp[i] = min(max_dp[i-1] * nums[i], min_dp[i-1] * nums[i], nums[i])
        
        return max(max_dp)
           

##########
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0
        
        if len(nums) == 1:
            return nums[0]
        
        min_so_far, max_so_far, max_global = nums[0], nums[0], nums[0]
        for i in range(1, len(nums)):
            max_so_far, min_so_far = max(min_so_far*nums[i], max_so_far*nums[i], nums[i]), min(min_so_far*nums[i], max_so_far*nums[i], nums[i])
            max_global = max(max_global, max_so_far)
        
        return max_global