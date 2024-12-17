class Solution:
    def minCostII(self, costs: List[List[int]]) -> int:
        houses = len(costs)
        dp = [[-1] * len(costs[0]) for _ in range(houses + 1)] #dp[house][i] = min cost starting at that house if you CANNOT choose ith color at that house
        def helper(house, bannedColor):
            minCost = float('inf')
            if bannedColor != -1 and dp[house][bannedColor] != -1:
                return dp[house][bannedColor]
            for color in range(len(costs[0])):
                if color != bannedColor:
                    currCost = costs[house][color]
                    if house == houses - 1:
                        otherCost = 0
                    else:
                        otherCost = helper(house + 1, color)
                    minCost = min(minCost, currCost + otherCost)
            if bannedColor != -1:
                dp[house][bannedColor] = minCost
            return minCost
        return helper(0, -1)