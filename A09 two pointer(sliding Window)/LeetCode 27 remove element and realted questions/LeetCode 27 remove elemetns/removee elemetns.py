class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        i=0
        for n in nums:
            if n!=val:
                nums[i]=n
                i+=1
        return i


#####below method using python function feature. above is better based on design
class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        while val in nums:
            nums.remove(val)
        return len(nums)
