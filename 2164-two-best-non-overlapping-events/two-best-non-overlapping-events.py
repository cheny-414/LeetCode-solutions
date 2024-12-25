class Solution:
    def maxTwoEvents(self, events: List[List[int]]) -> int:
        n = len(events)
        events.sort()
        dp = [[-1] * 3 for _ in range(n)] #max value we can get starting at ith event with k events remaining

        def maxValue(start, eventsDone):
            if start >= n or eventsDone == 2:
                return 0
            if dp[start][eventsDone] != -1:
                return dp[start][eventsDone]
            # choose this event:
            #find next index:
            left = start + 1
            right = n - 1
            nextIndex = n
            while left <= right:
                mid = left + (right - left) // 2
                if events[mid][0] > events[start][1]:
                    nextIndex = mid
                    right = mid - 1
                else:
                    left = mid + 1
            choose = events[start][2] + maxValue(nextIndex, eventsDone + 1)
            # skip this event:
            skip = maxValue(start + 1, eventsDone)
            dp[start][eventsDone] = max(choose, skip)
            return dp[start][eventsDone]
        return maxValue(0, 0)
