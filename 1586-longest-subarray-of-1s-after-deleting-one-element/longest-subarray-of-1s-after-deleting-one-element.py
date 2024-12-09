class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        if min(nums) == 1:
            return len(nums) - 1
        left = 0
        allowance = 1
        for right in range(len(nums)):
            if nums[right] == 0:
                allowance -= 1
            if allowance < 0:
                if nums[left] == 0:
                    allowance += 1
                left += 1
        return right - left