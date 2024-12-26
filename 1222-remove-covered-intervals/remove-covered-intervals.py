class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key = lambda x: (x[0], -x[1]))
        newIntervals = [intervals[0]]
        for i in range(1, len(intervals)):
            if newIntervals[-1][1] < intervals[i][1]:
                newIntervals.append(intervals[i])
        return len(newIntervals)
            