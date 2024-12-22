class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        left = 0
        product = 1
        result = 0
        for right in range(len(nums)):
            product *= nums[right]
            while left <= right and product >= k:
                product = product // nums[left]
                left += 1
            result += (right - left + 1)
        return result