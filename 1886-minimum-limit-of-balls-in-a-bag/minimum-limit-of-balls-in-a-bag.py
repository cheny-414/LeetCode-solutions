class Solution:
    def minimumSize(self, nums: List[int], maxOperations: int) -> int:
        def canPerform(limit):
            times = 0
            for num in nums:
                times += (num - 1) // limit
            return times <= maxOperations
        left = 1
        right = max(nums)
        ans = right
        while left <= right:
            mid = left + (right - left) // 2
            if canPerform(mid):
                ans = mid
                right = mid - 1
            else:
                left = mid + 1
        return ans