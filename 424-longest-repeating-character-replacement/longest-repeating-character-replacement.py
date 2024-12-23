class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left = 0
        freq = [0] * 26
        longest = 0
        for right in range(len(s)):
            freq[ord(s[right]) - ord('A')] += 1
            mostFreq = max(freq)
            opsNeeded = (right - left + 1) - mostFreq
            while opsNeeded > k:
                freq[ord(s[left]) - ord('A')] -= 1
                left += 1
                opsNeeded = (right - left + 1) - max(freq)
            longest = max(longest, right - left + 1)
        return longest