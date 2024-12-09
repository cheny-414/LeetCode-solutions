class Solution:
    def minimumDifference(self, nums: List[int]) -> int:
        n = len(nums) // 3

        # calculate max_sum using min_heap for second part
        min_heap = nums[(2 * n) :]
        heapq.heapify(min_heap)

        max_sum = [0] * (n + 2)
        max_sum[n + 1] = sum(min_heap)
        for i in range((2 * n) - 1, n - 1, -1):
            # push current
            heapq.heappush(min_heap, nums[i])
            # popout minimum from heap
            val = heapq.heappop(min_heap)
            # max_sum for this partition
            max_sum[i - n + 1] = max_sum[i - n + 2] - val + nums[i]


        # calculate min_sum using max_heap for first part
        max_heap = [-x for x in nums[:n]]
        heapq.heapify(max_heap)

        min_sum = [0] * (n + 2)
        min_sum[0] = -sum(max_heap)
        for i in range(n, (2 * n)):
            # push current
            heapq.heappush(max_heap, -nums[i])
            # popout maximum from heap
            val = -heapq.heappop(max_heap)
            # min_sum for this partition
            min_sum[i - n + 1] = min_sum[i - n] - val + nums[i]


        # find min difference bw second part (max_sum) and first part (min_sum)
        ans = math.inf
        for i in range(0, n + 1):
            print(i, min_sum[i], max_sum[i])
            ans = min((min_sum[i] - max_sum[i + 1]), ans)

        return ans