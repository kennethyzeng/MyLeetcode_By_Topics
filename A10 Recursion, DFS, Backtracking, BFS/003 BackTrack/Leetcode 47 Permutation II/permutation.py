class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.used = [False]*len(nums)
        
        def dfs(nums, temp):
            if len(temp) == len(nums):
                self.res.append(temp[:])
                
            for i in xrange(len(nums)):
                if self.used[i]: continue
                if i > 0 and nums[i] == nums[i-1] and !self.used[i-1]: continue
                self.used[i] = True
                temp.append(nums[i])
                dfs(nums, temp)
                self.used[i] = False
                temp.pop()
                
        dfs(sorted(nums), [])
        return self.res



##backtracking 1
class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.used = [False]*len(nums)
        
        def dfs(nums, temp):
            if len(temp) == len(nums):
                self.res.append(temp[:])
                
            for i in range(len(nums)):
                if self.used[i]: continue
                if i > 0 and nums[i] == nums[i-1] and not self.used[i-1]: continue
                self.used[i] = True
                temp.append(nums[i])
                dfs(nums, temp)
                self.used[i] = False
                temp.pop()
                
        dfs(sorted(nums), [])
        return self.res

##backtracking 2
def permuteUnique(self, nums):
    res = []
    nums.sort()
    self.dfs(nums, [], res)
    return res
    
def dfs(self, nums, path, res):
    if not nums:
        res.append(path)
    for i in xrange(len(nums)):
        if i > 0 and nums[i] == nums[i-1]:
            continue
        self.dfs(nums[:i]+nums[i+1:], path+[nums[i]], res)

#######iterative
def permuteUnique(nums):
        ret = [[]]
        for n in nums:
            temp = []
            for item in ret:
                for i in xrange(len(item) + 1):
                    temp += item[:i] + [n] + item[i:],
                    if i < len(item) and item[i] == n:
                        break
            ret = temp
        return ret if any(ret) else []