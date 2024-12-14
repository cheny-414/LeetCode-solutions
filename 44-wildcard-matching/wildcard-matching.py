class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        dp = [[0] * (len(p) + 1) for _ in range(len(s) + 1)]
        #
        #*
        def solve(i, j):
            if i >= len(s) and j >= len(p):
                return True
            if j >= len(p):
                return False
            if dp[i][j] != 0:
                return dp[i][j] == 1
            solvable = False
            hasStar = p[j] == '*'
            isMatch = i < len(s) and (s[i] == p[j] or p[j] == '?')
            if (hasStar and i < len(s)) or isMatch:
                solvable |= solve(i + 1, j + 1)
            if hasStar:
                if i < len(s):
                    solvable |= solve(i + 1, j)
                if j < len(p):
                    solvable |= solve(i, j + 1)
            dp[i][j] = 1 if solvable else 2
            return solvable
        return solve(0,0)