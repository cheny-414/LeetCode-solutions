class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        counter = Counter(s)
        currentFlips = counter.get('0', 0)
        answer = currentFlips
        for split in range(len(s)):
            if s[split] == '0':
                currentFlips -= 1
                answer = min(answer, currentFlips)
            else:
                currentFlips += 1
        return answer