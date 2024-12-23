class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        distinct = {}
        left = 0
        longest = 0
        for right in range(len(s)):
            if s[right] not in distinct:
                distinct[s[right]] = 1
            else:
                distinct[s[right]] += 1
            while len(distinct) > k:
                distinct[s[left]] -= 1
                if not distinct[s[left]]:
                    del distinct[s[left]]
                left += 1
            longest = max(longest, right - left + 1)
        return longest