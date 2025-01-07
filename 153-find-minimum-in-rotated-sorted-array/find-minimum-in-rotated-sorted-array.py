class Solution:
    def findMin(self, nums: List[int]) -> int:
        return min(nums)
        if len(nums) == 1 or nums[0] < nums[-1]:
            return nums[0]
        left = 0
        right = len(nums) - 1
        min_pos = -1
        while left <= right:
            mid = left + (right - left) // 2
            if (mid == len(nums) - 1 or nums[mid] < nums[mid + 1]) and (mid == 0 or nums[mid] < nums[mid - 1]):
                return nums[mid]
            if nums[mid] < nums[-1]:
                #search on left
                right = mid - 1
            else:
                left = mid + 1
        return -1

        #6, 7, 8, 9, 10, 11, 12, 1, 2, 3
                