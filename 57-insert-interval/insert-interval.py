class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        result = []
        curr = newInterval
        appended = False
        if not intervals:
            result.append(newInterval)
            return result
        for interval in intervals:
            if interval[1] < newInterval[0]:
                result.append(interval)
            elif interval[0] > newInterval[1]:
                if curr[0] != float('inf'):
                    result.append(curr)
                    appended = True
                    curr = [float('inf'), -float('inf')]
                result.append(interval)
            else:
                curr[0] = min(curr[0], interval[0], newInterval[0])
                curr[1] = max(curr[1], interval[1], newInterval[1])
        if not appended:
            result.append(curr)
        return result