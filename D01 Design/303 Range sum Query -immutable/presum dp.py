###########
Time Complexity:
Space Complexity:


#############
class NumArray:

    def __init__(self, nums: List[int]):
        self.preSum = nums
        for i in range(len(nums) - 1):
            self.preSum[i+1] += self.preSum[i] # preSum[i+1] = preSum[i] + preSum[i+1]

    def sumRange(self, left: int, right: int) -> int:
        if (left ==0): return self.preSum[right]
        return self.preSum[right] - self.preSum[left -1]


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(left,right)