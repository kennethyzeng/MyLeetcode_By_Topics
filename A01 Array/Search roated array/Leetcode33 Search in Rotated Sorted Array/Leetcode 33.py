#############
Binary search to find index of pivot (where the array has been rotated).
Normal Binary search on both sides of pivot to find element
Code uses the property that the last element of array will be smaller than all elements before the pivot. See example below to clarify:
example: in rotated array: 8,9,11,5,6,7. We know 5 is the pivot.
All elements on left side of pivot are larger than last element, 7
All elements on right side of pivot including pivot are smaller than last element, 7.
We can use this property to binary search and find pivot, once we have pivot, run normal bin_search on both sides of pivot and we're done woohoo!
##############


class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if(not nums):
            return -1
        pivot_index = self.find_pivot(nums) 
        result = self.bin_search(nums, target, 0, pivot_index-1)
        if(result!=-1):
            return result
        else:
            return self.bin_search(nums, target, pivot_index, len(nums)-1)
        
    def find_pivot(self, arr):
	#compare last element to mid element. 
	#If mid element is greater than last element, pivot must be on right move low to mid+1
	#If mid element is less than last element, move high to mid-1
        element_to_compare = arr[-1]
        low = 0
        high = len(arr)-1    
        while(low <= high):
            mid = (low+high)//2
            if element_to_compare < arr[mid]:
                low = mid+1
            elif element_to_compare >= arr[mid]:
                high = mid-1
        return low    

    def bin_search(self, arr, value, low, high):     
        while(low <= high):
            mid = (low+high)/2
            if value<arr[mid]:
                high = mid-1
            elif value>arr[mid]:
                low = mid+1
            else:
                return mid
        return -1