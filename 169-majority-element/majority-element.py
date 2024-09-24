class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        count = 0
        majority = nums[0]
        for i in range(len(nums)):
            if count == 0:
                    majority = nums[i]
            if nums[i] == majority:
                count += 1
            else:
                count -= 1
        return majority