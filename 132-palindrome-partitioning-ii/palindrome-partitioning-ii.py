class Solution:
    def minCut(self, s: str) -> int:
        dp = [[0] * len(s) for _ in range(len(s))]
        dp2 = [[-1] * len(s) for _ in range(len(s))]
        def isPalindrome(start, end):
            if start >= end:
                return True
            if dp[start][end] != 0:
                return dp[start][end] == 1
            if s[start] == s[end]:
                dp[start][end] = 1 if isPalindrome(start + 1, end - 1) else 2
                return dp[start][end] == 1
            dp[start][end] = 2
            return False
        def helper(start, end):
            ret = float('inf')
            if dp2[start][end] != -1:
                return dp2[start][end]
            for i in range(start, end + 1):
                if isPalindrome(start, i):
                    if i + 1 < len(s):
                        ret = min(ret, 1 + helper(i + 1, end))
                    else:
                        ret = 1
            dp2[start][end] = ret
            return ret
        return helper(0, len(s) - 1) - 1