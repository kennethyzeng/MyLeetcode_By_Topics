###########
Time Complexity:
Space Complexity:


#############
class Solution:
	def myPow(self, x: float, n: int) -> float:
		if n == 0: return 1
		if n < 0: n, x = -n, 1 / x
		lower = self.myPow(x, n//2)
		return lower * lower * x if n % 2 else lower * lower

######## Python Pure Recursion with Memoization.
class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        memo = {}      
        def power(x,n):
            if n in memo:return memo[n]
            if n==0: return 1
            elif n==1:return x
            elif n < 0:
                memo[n] = power(1/x,-n)
                return memo[n]
            elif n%2==0:
                memo[n] = power(x*x,n//2)
                return memo[n]
            else:
                memo[n] = x * power(x*x,(n-1)//2)
                return memo[n]
            
        return power(x,n)
class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        memo = {}      
        def power(x,n):
            if n in memo:return memo[n]
            if n==0: return 1
            elif n==1:return x
            elif n < 0:
                memo[n] = power(1/x,-n)
                return memo[n]
            elif n%2==0:
                memo[n] = power(x*x,n//2)
                return memo[n]
            else:
                memo[n] = x * power(x*x,(n-1)//2)
                return memo[n]
            
        return power(x,n)