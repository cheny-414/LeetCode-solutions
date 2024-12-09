class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        slow = 0
        count = 0
        for fast in range(len(nums)):
            if nums[fast] == 0:
                count += 1
            else:
                nums[slow] = nums[fast]
                slow += 1
        while count:
            nums[slow] = 0
            slow += 1
            count -= 1