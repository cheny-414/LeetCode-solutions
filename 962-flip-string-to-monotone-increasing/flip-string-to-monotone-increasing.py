class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        dp = [[-1] * 2 for _ in range(len(s))]
        def helper(index, requireOne):
            if index >= len(s):
                return 0
            if dp[index][requireOne] != -1:
                return dp[index][requireOne]
            flips = inf
            if not requireOne:
                #flip to zero
                flips = min(flips, (1 if s[index] == '1' else 0) + min(helper(index + 1, 0), helper(index + 1, 1)))
            #flip to one
            flips = min(flips, (1 if s[index] == '0' else 0) + helper(index + 1, 1))
            dp[index][requireOne] = flips
            return flips
        a = min(helper(0, 0), helper(0, 1))
        return a
            