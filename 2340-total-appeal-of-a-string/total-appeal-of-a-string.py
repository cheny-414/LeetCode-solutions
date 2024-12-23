class Solution:
    def appealSum(self, s: str) -> int:
        #c, b, c, d, e, c
        last_pos = [-1] * 26
        dp = 0
        total = 0
        for i in range(len(s)):
            char_idx = ord(s[i]) - ord('a')
            if last_pos[char_idx] == -1:
                dp = dp + 1 + i
            else:
                dp = dp + (i - last_pos[char_idx])
            last_pos[ord(s[i]) - ord('a')] = i
            total += dp
        return total