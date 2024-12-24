class Solution:
    def minimumSumSubarray(self, nums: List[int], l: int, r: int) -> int:
        #0, 1, 2, 3
        #1, 2, 3, 4
        #1, 3, 6, 10
        prefix_sum = [0] * len(nums)
        for i, num in enumerate(nums):
            prev = 0 if i == 0 else prefix_sum[i - 1]
            prefix_sum[i] = prev + num
        def findMin(length):
            minSum = float('inf')
            # running = 0
            # for i in range(length):
            #     running += nums[i]
            # if running > 0:
            #     minSum = running
            for i in range(length - 1, len(nums)):
                running = prefix_sum[i] - (0 if i == length - 1 else prefix_sum[i - length])
                if running > 0:
                    minSum = min(minSum, running)
            return minSum
        best = float('inf')
        for length in range(l, r + 1):
            best = min(best, findMin(length))
        return best if best != float('inf') else -1