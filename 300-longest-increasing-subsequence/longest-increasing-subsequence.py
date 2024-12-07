class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = [1] * len(nums)
        for i in range(len(nums)):
            max_len = 1
            for j in range(i):
                if nums[j] < nums[i]:
                    max_len = max(max_len, 1 + dp[j])
            dp[i] = max_len
        return max(dp)