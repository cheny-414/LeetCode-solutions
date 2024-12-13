class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        n = len(nums) // 3

        max_heap = [-x for x in nums[:n]]
        heapify(max_heap)
        min_sum = [0] * (n + 1)
        min_sum[0] = -sum(max_heap)

        for i in range(n, 2 * n):
            heappush(max_heap, -nums[i])
            val = -heappop(max_heap)
            min_sum[i - n + 1] = min_sum[i - n] - val + nums[i]

        min_heap = nums[2*n:]
        heapify(min_heap)
        max_sum = [0] * (n + 1)
        max_sum[n] = sum(min_heap)

        best = float('inf')
        for i in range(2 * n - 1, n - 1, -1):
            heappush(min_heap, nums[i])
            val = heappop(min_heap)
            max_sum[i - n] = max_sum[i - n + 1] - val + nums[i]

        for i in range(0, n + 1):
            left = min_sum[i]
            right = max_sum[i]
            best = min(best, left - right)
        return best