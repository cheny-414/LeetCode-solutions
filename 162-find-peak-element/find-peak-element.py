class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        if len(nums) == 2:
            return nums.index(max(nums))
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            #ascending
            if (mid == 0 or nums[mid - 1] < nums[mid]) and mid + 1 < len(nums) and nums[mid + 1] > nums[mid]:
                left = mid + 1
            elif nums[mid - 1] > nums[mid]:
                right = mid - 1
            else:
                return mid