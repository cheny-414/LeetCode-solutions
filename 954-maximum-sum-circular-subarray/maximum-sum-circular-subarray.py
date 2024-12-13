class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        currMax = 0
        currMin = 0
        bestMaxSum = nums[0]
        bestMinSum = nums[0]
        total = 0
        for num in nums:
            currMax = max(currMax + num, num)
            currMin = min(currMin + num, num)
            bestMaxSum = max(bestMaxSum, currMax)
            bestMinSum = min(bestMinSum, currMin)
            total += num
        if total == bestMinSum:
            return bestMaxSum
        return max(bestMaxSum, total - bestMinSum)