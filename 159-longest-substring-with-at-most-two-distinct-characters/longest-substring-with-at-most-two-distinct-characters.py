class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        left = 0
        counter = Counter()
        longest = 0
        for right in range(len(s)):
            counter[s[right]] += 1
            while len(counter) > 2:
                counter[s[left]] -= 1
                if not counter[s[left]]:
                    del counter[s[left]]
                left += 1
            longest = max(longest, right - left + 1)
        return longest