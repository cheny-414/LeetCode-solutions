class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        #3, 4, 2, 1
        #2, 4, 3, 1
        #2, 1, 3, 4
        onePresent = False
        for i in range(len(nums)):
            if nums[i] <= 0 or nums[i] > len(nums):
                nums[i] = 1
            elif nums[i] == 1:
                onePresent = True
        if not onePresent:
            return 1
        for i in range(len(nums)):
            index = abs(nums[i])
            if index == len(nums):
                index = 0
            if nums[index] > 0:
                nums[index] = -nums[index]
        for i in range(1, len(nums)):
            if nums[i] > 0:
                return i
        if nums[0] > 0:
            return len(nums)
        return len(nums) + 1
