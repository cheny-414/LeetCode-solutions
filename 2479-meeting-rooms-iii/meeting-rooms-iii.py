class Solution:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        available = [i for i in range(n)] # room num
        used = [] #endtime, room num
        counts = [0] * n
        meetings.sort()
        for start, end in meetings:
            while used and used[0][0] <= start:
                heappush(available, heappop(used)[1])
            if not available:
                #delay current meeting
                earliestTime = used[0][0]
                end = earliestTime + (end - start)
                heappush(available, heappop(used)[1])
            roomToUse = heappop(available)
            heappush(used, [end, roomToUse])
            counts[roomToUse] += 1
        return counts.index(max(counts))
