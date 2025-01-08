class Solution:
    def shortestPalindrome(self, s: str) -> str:
        # a a c e c a a a # a a a c e c a a
        reverse_string = s[::-1]
        combined = s + '#' + reverse_string
        def kmp(string):
            lps = [0] * len(string)
            prev_lps, i = 0, 1
            while i < len(string):
                if string[i] == string[prev_lps]:
                    lps[i] = prev_lps + 1
                    prev_lps += 1
                    i += 1
                elif prev_lps == 0:
                    lps[i] = 0
                    i += 1
                else:
                    prev_lps = lps[prev_lps - 1]
            return lps
        lps = kmp(combined)
        palindrome_length = lps[-1]
        #d c b a
        suffix = reverse_string[:len(s) - palindrome_length]
        return suffix + s