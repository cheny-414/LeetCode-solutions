class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        start = sorted([i[0] for i in intervals])
        end = sorted(i[1] for i in intervals)

        p1 = 0
        p2 = 0
        counter = 0
        maxi = 0
        while p1 < len(intervals):
            if end[p2] <= start[p1]:
                counter -= 1
                p2 += 1
            else:
                counter += 1
                p1 += 1
            maxi = max(maxi, counter)
        return maxi

