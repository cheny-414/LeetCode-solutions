class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        n = len(triangle[-1])
        m = len(triangle)
        #dp = [[float('inf')] * n for _ in range(m)]
        dp_alt = [float('inf')] * n

        for i in range(n):
            #dp[m - 1][i] = triangle[m - 1][i]
            dp_alt[i] = triangle[m - 1][i]
        for i in range(m - 2, -1, -1):
            #new_dp = [0] * n
            for j in range(n - (m - i - 1)):
                #dp[i][j] = min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]
                dp_alt[j] = min(dp_alt[j], dp_alt[j + 1]) + triangle[i][j]
            #dp_alt = new_dp
        return dp_alt[0]