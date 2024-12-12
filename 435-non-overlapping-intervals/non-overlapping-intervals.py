class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        stack = []
        intervals.sort()
        for interval in intervals:
            while stack and stack[-1][1] > interval[1]:
                stack.pop()
            if not stack or stack[-1][1] <= interval[0]:
                stack.append(interval)
        return len(intervals) - len(stack)