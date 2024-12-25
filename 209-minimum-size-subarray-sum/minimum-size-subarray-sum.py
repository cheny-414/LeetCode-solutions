class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        left = 0
        sum = 0
        shortest = float('inf')
        for right in range(len(nums)):
            sum += nums[right]
            while sum >= target:
                shortest = min(shortest, right - left + 1)
                sum -= nums[left]
                left += 1  
        return shortest if shortest != float('inf') else 0
            