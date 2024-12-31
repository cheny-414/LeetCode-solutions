class Solution:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        dp = {}
        def helper(index):
            if index > high - 1:
                return 0
            # if index == high - 1:
            #     return 1
            if index in dp:
                return dp[index]
            ways = 0
            if index >= low - 1:
                #not append anything
                ways += 1
            #append zero
            ways += helper(index + zero)
            #append one
            ways += helper(index + one)
            dp[index] = ways % (10**9 + 7)
            return dp[index]
        return helper(-1) % (10**9 + 7)