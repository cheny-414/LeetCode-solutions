class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        p = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                nums[p] = nums[i]
                p += 1
        return p