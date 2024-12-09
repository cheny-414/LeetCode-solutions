class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        maximum = nums[0]
        running = nums[0]
        for num in nums[1:]:
            if num > running + num:
                running = num
            else:
                running += num
            maximum = max(maximum, running)
        return maximum