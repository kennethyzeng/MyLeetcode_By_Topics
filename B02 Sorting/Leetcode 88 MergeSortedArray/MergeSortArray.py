#####o(n)

def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
	writeIndex = m + n - 1
	m, n = m-1, n-1
	
	while n>=0 and m>=0:
		if nums1[m] > nums2[n]:
			nums1[writeIndex] = nums1[m]
			#nums1[m] = float("-inf")           We don't need to change this value because m will be pointing to m-1
			m -= 1
		else:
			nums1[writeIndex] = nums2[n]
			n -= 1
		writeIndex -= 1
		
	if n>-1:
		nums1[0:n+1] = nums2[0:n+1]


##########
class Solution:
    def merge(self, n1: List[int], m: int, n2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        while m > 0 and n > 0:
            if n1[m - 1] > n2[n - 1]:
                n1[m + n - 1] = n1[m - 1]
                m -= 1
            else:
                n1[m + n - 1] = n2[n - 1]
                n -= 1
        n1[:n] = n2[:n]