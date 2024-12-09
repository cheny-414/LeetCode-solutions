class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        prefix = [0] * len(nums)
        suffix = [0] * len(nums)
        preSum = 0
        for i in range(len(nums)):
            prefix[i] = preSum
            preSum += nums[i]
        preSum = 0
        for i in reversed(range(len(nums))):
            suffix[i] = preSum
            preSum += nums[i]
        for i in range(len(nums)):
            if prefix[i] == suffix[i]:
                return i
        return -1