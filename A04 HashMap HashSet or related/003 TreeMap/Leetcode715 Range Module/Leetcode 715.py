##################
Straightforward Python list solution with explanation, O(N) add/remove, O(logN) query
##############



import bisect


class RangeModule:

    def __init__(self):
        '''Straight forward implementation'''
        self.intervals = []
        

    def addRange(self, left: int, right: int) -> None:
        # how to insert, standard merge insert.
        # used from https://leetcode.com/problems/merge-intervals/submissions/
        # O(N)
        bisect.insort_left(self.intervals, [left, right])
        new_intervals = []
        for start, end in self.intervals:
            if len(new_intervals) == 0 or new_intervals[-1][1] < start:
                new_intervals.append([start, end])
            elif end >= new_intervals[-1][1]:
                new_intervals[-1][1] = end
        
        self.intervals = new_intervals
        # print(self.intervals)
        

    def queryRange(self, left: int, right: int) -> bool:
        ## O(logN) query with binary search
        n = len(self.intervals)
        # handle special case
        if n == 0:
            return False
        start, end = 0, n - 1
        while start + 1 < end:
            mid = (start + end) // 2
            mid_left, mid_right = self.intervals[mid]
            if mid_right < left:
                start = mid
            elif mid_left > right:
                end = mid
            else:
                # has overlap,  
                # we can directly return result
                # by make sure it is a whole cover
                return mid_left <= left and mid_right >= right
        
        start_left, start_right = self.intervals[start]
        end_left, end_right = self.intervals[end]
        return (start_left <= left and start_right >= right) or (end_left <= left and end_right >= right)
        

    def removeRange(self, left: int, right: int) -> None:
        ## How to remove
        ## O(N)
        new_intervals = []
        for start, end in self.intervals:
            if end <= left or start >= right:
                new_intervals.append([start, end])
            else:
                if start < left:
                    new_intervals.append([start, left])
                if end > right:
                    new_intervals.append([right, end])
        self.intervals = new_intervals