###O(N^3) time complixity 
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        def find_quadruples(nums, first, second, quadruples):
            left = second+1
            right = len(nums)-1
            while left < right:
                sum = nums[first]+nums[second]+nums[left]+nums[right]
                if sum == target:
                    quadruples.append([nums[first], nums[second], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    while left < right and nums[left] == nums[left-1]:
                        left += 1
                    while left < right and nums[right] == nums[right+1]:
                        right -= 1
                elif sum < target:
                    left += 1
                else: right -= 1
        
        if len(nums) < 4: return []
        quadruples = []
        nums.sort()
        for i in range(len(nums)-3):
            if i > 0 and nums[i] == nums[i-1]: continue
            for j in range(i+1,len(nums)-2):
                if j > i+1 and nums[j] == nums[j-1]: continue
                find_quadruples(nums, i, j, quadruples)
        return quadruples