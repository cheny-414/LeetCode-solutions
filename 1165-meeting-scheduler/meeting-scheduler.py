class Solution:
    def minAvailableDuration(self, slots1: List[List[int]], slots2: List[List[int]], duration: int) -> List[int]:
        slots1.sort()
        slots2.sort()
        m, n = len(slots1), len(slots2)
        i = j = 0
        while i < m and j < n:
            time1 = slots1[i]
            time2 = slots2[j]
            if time1[0] > time2[1]:
                j += 1
            elif time2[0] > time1[1]:
                i += 1
            else:
                currStart = max(time1[0], time2[0])
                currEnd = min(time1[1], time2[1])
                if currEnd - currStart >= duration:
                    return [currStart, currStart + duration]
                if time1[1] < time2[1]:
                    i += 1
                else:
                    j += 1
        return []