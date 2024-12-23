class Solution:
    def secondsToRemoveOccurrences(self, s: str) -> int:
        count = s.count('1')
        blockers = 0
        timeNeeded = 0
        correctIndex = -1
        for i in range(len(s)):
            if s[i] == '1':
                correctIndex += 1
                time = 0
                if i == correctIndex:
                    blockers = max(0, blockers - 1)
                else:
                    time = i - correctIndex + blockers
                    blockers += 1
                timeNeeded = max(timeNeeded, time)
            else:
                blockers = max(0, blockers - 1)
        return timeNeeded