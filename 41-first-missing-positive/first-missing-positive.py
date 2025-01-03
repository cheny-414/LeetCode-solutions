class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        mySet = set(nums)
        for i in range(1, len(nums) + 1):
            if i not in mySet:
                return i
        return len(nums) + 1