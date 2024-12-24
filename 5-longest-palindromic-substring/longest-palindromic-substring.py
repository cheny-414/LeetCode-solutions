class Solution:
    def longestPalindrome(self, s: str) -> str:
        best = ""
        longest = 0
        for i in range(len(s)):
            length = 1
            j = k = i
            while j > 0 and k < len(s) - 1 and s[j - 1] == s[k + 1]:
                length += 2
                j -= 1
                k += 1
            if length > longest:
                longest = length
                best = s[j:k+1]
        for i in range(len(s) - 1):
            length = 0
            j = i
            k = i + 1
            while j >= 0 and k < len(s) and s[j] == s[k]:
                length += 2
                j -= 1
                k += 1
            if length > longest:
                longest = length
                best = s[j+1:k]
        return best