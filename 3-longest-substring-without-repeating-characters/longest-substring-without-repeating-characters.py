class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        map = {}
        left = 0
        longest = 0
        for right in range(len(s)):
            if s[right] not in map:
                map[s[right]] = 1
            else:
                map[s[right]] += 1
            while len(map) < right - left + 1:
                map[s[left]] -= 1
                if not map[s[left]]:
                    del map[s[left]]
                left += 1
            longest = max(longest, right - left + 1)
        return longest