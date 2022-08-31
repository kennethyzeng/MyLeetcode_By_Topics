class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        result = []
        intervals.sort(key=lambda x: x[0])
        begin, end = intervals[0][0], intervals[0][1]
        for interval in intervals[1:]:
            if interval[0] <= end:
                end = max(end, interval[1])
            else:
                result.append([begin, end])
                begin, end = interval[0], interval[1]
        result.append([begin, end])
        return result