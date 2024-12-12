class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        free = [0] * len(prices)
        hold = [0] * len(prices)
        hold[0] = -prices[0]
        for i in range(1, len(prices)):
            free[i] = max(hold[i - 1] + prices[i] - fee, free[i - 1])
            hold[i] = max(hold[i - 1], free[i - 1] - prices[i])

        return free[-1]