class Solution:
    def rob(self, nums: List[int]) -> int:
        @cache
        def profit(house, firstRobbed):
            if house >= len(nums):
                return 0
            #rob this house
            if house == len(nums) - 1 and firstRobbed:
                return 0
            profit1 = nums[house] + profit(house + 2, True if house == 0 else firstRobbed)
            #not rob this house
            profit2 = 0 + profit(house + 1, firstRobbed)
            return max(profit1, profit2)
        return profit(0, False)