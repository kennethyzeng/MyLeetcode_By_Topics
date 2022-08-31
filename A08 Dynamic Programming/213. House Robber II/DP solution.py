###########
Time Complexity:
Space Complexity:


#############
class Solution:
    def rob(self, nums: List[int]) -> int:
        if (len(nums) == 0): 
            return 0
        if (len(nums) == 1):
            return nums[0]
        if (len(nums) == 2):
            return max(nums)
        
        dp1 = [0]*len(nums) 
        dp2 = [0]*len(nums)
        
        #start from 1st house 
        dp1[0], dp1[1] = nums[0], max(nums[0], nums[1])
        for i in range(2, len(nums) -1):
            dp1[i] = max(nums[i] + dp1[i-2] , dp1[i-1])
            print(dp1[i])
         
       #start from second house
        dp2[0], dp2[1] = 0, nums[1]
        for j in range(2, len(nums)):

            dp2[j] = max(nums[j] + dp2[j-2] , dp2[j-1])
        print(dp1[len(nums) -2])
        print(dp2[len(nums) -1])
        return max(dp1[len(nums) -2], dp2[len(nums) -1])
            
        