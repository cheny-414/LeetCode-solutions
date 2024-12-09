class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        presum = 0
        result = -float('inf')
        for i in range(0, k - 1):
            presum += nums[i]
        for i in range(k - 1, len(nums)):
            drop = 0 if i == k - 1 else nums[i - k]
            sum = presum + nums[i] - drop
            result = max(result, sum)
            presum = sum
        return result / k