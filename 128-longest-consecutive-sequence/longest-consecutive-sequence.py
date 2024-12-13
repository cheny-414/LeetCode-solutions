class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nums.sort()
        streak = 0
        best = 0
        for i in range(len(nums)):
            if i == 0 or nums[i] == nums[i - 1] + 1:
                streak += 1
                best = max(best, streak)
            elif nums[i] == nums[i - 1]:
                continue
            else:
                streak = 1
        return best