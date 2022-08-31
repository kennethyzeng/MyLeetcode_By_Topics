
Time Complexity: O(n)
Space: O(1)


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        
        low, high, i = 0, len(nums) - 1, 0
        
        while i <= high:
            if nums[i] == 0:
                nums[low], nums[i] = nums[i], nums[low]
                low += 1
                i += 1
            elif nums[i] == 2:
                nums[high], nums[i] = nums[i], nums[high]
                high -= 1
            else: i += 1

################
class Solution:
    def sortColors(self, a: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        runner = 0
        left_partition = 0
        right_partition = len(a) - 1
        while runner <= right_partition:
            if a[runner] == 0:
                a[runner], a[left_partition] = a[left_partition], a[runner]
                runner += 1
                left_partition += 1
            elif a[runner] == 1:
                runner += 1
            else:
                a[runner], a[right_partition] = a[right_partition], a[runner]
                right_partition -= 1
        return a