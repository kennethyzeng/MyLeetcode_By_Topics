###########
Time Complexity: O(n)
Space Complexity:O(1)


#############
# A.1: Clearest Logic
class Solution:
    def maxProfit(self, prices):
        best = 0
        for i in range(1,len(prices)):
            if prices[i] > prices[i-1]:
                best += prices[i] - prices[i-1]
        return best