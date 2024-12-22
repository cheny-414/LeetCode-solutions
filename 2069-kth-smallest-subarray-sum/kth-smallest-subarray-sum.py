class Solution:
    def kthSmallestSubarraySum(self, nums: List[int], k: int) -> int:
        def num_subarrays_lte_x(x):
            total_num = 0
            running_sum = 0
            start_idx = 0
            for end_idx in range(len(nums)):
                running_sum += nums[end_idx]
                while running_sum > x:
                    running_sum -= nums[start_idx]
                    start_idx += 1
                total_num += (end_idx - start_idx) + 1
            return total_num
        left = min(nums)
        right = sum(nums)
        while left <= right:
            mid = left + (right - left) // 2
            if k <= num_subarrays_lte_x(mid):
                right = mid - 1
            else:
                left = mid + 1
        return left
