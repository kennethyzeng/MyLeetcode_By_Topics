###########


#############
class Solution:
    def firstBadVersion(self, n):
        l,u = 1,n
        while l<=u:
            mid = l + (u-l)//2
            if isBadVersion(mid):
                u = mid-1
            else:
                l = mid+1
        return l


##3########
class Solution(object):
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        lo, hi = 1, n
        while lo<hi:
            mid = lo+(hi-lo)//2
            if isBadVersion(mid) == True:
                hi = mid
            else:
                lo = mid+1
        return lo