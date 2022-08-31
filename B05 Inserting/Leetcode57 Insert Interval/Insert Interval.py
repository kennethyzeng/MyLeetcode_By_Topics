#####Python O( n ) by boundary checking

class Solution:
    def insert(self, intervals, newInterval):
        
        # Constant to help us access start point and end point of interval
        START, END = 0, 1
        
        s, e = newInterval[START], newInterval[END]
        
        left, right = [], []
        
        for cur_interval in intervals:
            
            if cur_interval[END] < s:
                # current interval is on the left-hand side of newInterval
                left += [ cur_interval ]
                
            elif cur_interval[START] > e:
                # current interval is on the right-hand side of newInterval
                right += [ cur_interval ]
                
            else:
                # current interval has overlap with newInterval
                # merge and update boundary
                s = min(s, cur_interval[START])
                e = max(e, cur_interval[END])
                
        return left + [ [s, e] ] + right    

    #####################
    class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
	
        # edge case #1: no intervals in original list
        if len(intervals) == 0:
            return [newInterval]
			
        # edge case #2: new interval goes in the end of the list with no overlap
        if intervals[-1][1] < newInterval[0]:
            return intervals + [newInterval]
			
        # edge case #3: new interval goes in the beginning of the list with no overlap
        if newInterval[1] < intervals[0][0]:
            return [newInterval] + intervals
			
        res = []
        i = 0
        for curr_interval in intervals:
            # new interval doesn't overlap
            if curr_interval[1] < newInterval[0]:
                res.append(curr_interval)
            else:
                first = min(curr_interval[0], newInterval[0])
                last = newInterval[1]
                i = intervals.index(curr_interval)
				
                # while new interval overlaps:
                while i < len(intervals) and last >= intervals[i][0]:
                    last = max(intervals[i][1], newInterval[1])
                    i+=1
                res.append([first, last])
                break
				
        # add the rest
        res += intervals[i:]
        return res