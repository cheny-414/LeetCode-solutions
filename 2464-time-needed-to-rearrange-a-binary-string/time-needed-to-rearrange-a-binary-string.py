class Solution:
    def secondsToRemoveOccurrences(self, s: str) -> int:
        count = s.count('1')
        blockers = 0
        timeNeeded = 0
        curr = -1
        for i in range(len(s)):
            if s[i] == '1':
                curr += 1
                time = 0
                if i == curr:
                    blockers = max(0, blockers - 1)
                else:
                    time = i - curr + blockers
                    blockers += 1
                timeNeeded = max(timeNeeded, time)
            else:
                blockers = max(0, blockers - 1)
        return timeNeeded