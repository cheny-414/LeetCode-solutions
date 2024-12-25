class Solution:
    def minWindow(self, s: str, t: str) -> str:
        target = Counter(t)
        curr = Counter()
        left = 0
        charsNeeded = len(target)
        shortest = float('inf')
        indices = [-1, -1]
        for right in range(len(s)):
            curr[s[right]] += 1
            if s[right] in target and curr[s[right]] == target[s[right]]:
                charsNeeded -= 1
            while charsNeeded == 0:
                if right - left + 1 < shortest:
                    shortest = right - left + 1
                    indices = [left, right]
                if s[left] in target:
                    curr[s[left]] -= 1
                    if curr[s[left]] < target[s[left]]:
                        charsNeeded += 1
                left += 1
        return s[indices[0]:indices[1] + 1]