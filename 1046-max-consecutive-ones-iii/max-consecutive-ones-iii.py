class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        left = 0
        zeroes = 0
        longest = 0
        for right in range(len(nums)):
            size = right - left + 1
            if nums[right] == 0:
                zeroes += 1
            if zeroes > k:
                if nums[left] == 0:
                    zeroes -= 1
                left += 1
            else:
                longest = max(longest, size)
        return longest