class Solution:
    def numSquares(self, n: int) -> int:
        dp = {}
        def helper(n):
            num = float('inf')
            if n == 0 or n == 1:
                return n
            if n in dp:
                return dp[n]
            for i in range(1, int(n**(1/2) + 1)):
                curr_sq = i ** 2
                num = min(num, 1 + helper(n - curr_sq))
            dp[n] = num
            return num
        return helper(n)