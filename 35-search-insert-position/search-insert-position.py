class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        ret = len(nums)
        while left <= right:
            mid = left + (right - left) // 2
            if nums[mid] >= target:
                ret = mid
                right = mid - 1
            else:
                left = mid + 1
        return ret