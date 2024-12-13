class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        currMax = 0
        currMin = 0
        bestMax = nums[0]
        bestMin = nums[0]
        total = 0
        for num in nums:
            currMax = max(currMax + num, num)
            currMin = min(currMin + num, num)
            bestMax = max(bestMax, currMax)
            bestMin = min(bestMin, currMin)
            total += num
        if total == bestMin:
            return bestMax
        return max(bestMax, total - bestMin)