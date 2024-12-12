class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle[-1])
        m = len(triangle)
        dp = [[float('inf')] * n for _ in range(m)]

        for i in range(n):
            dp[m - 1][i] = triangle[m - 1][i]
        for i in range(m - 2, -1, -1):
            for j in range(n - (m - i - 1)):
                dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]
        return dp[0][0]