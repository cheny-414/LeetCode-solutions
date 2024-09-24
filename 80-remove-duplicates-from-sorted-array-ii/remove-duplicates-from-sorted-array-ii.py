class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        p = 1
        seen = False
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                nums[p] = nums[i]
                p += 1
                seen = False
            elif seen == False:
                nums[p] = nums[i]
                seen = True
                p += 1
        return p