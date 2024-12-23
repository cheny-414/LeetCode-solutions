class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        maxElement = max(nums)
        left = 0
        countMax = 0
        res = 0
        for right in range(len(nums)):
            if nums[right] == maxElement:
                countMax += 1
            while countMax > k - 1:
                if nums[left] == maxElement:
                    countMax -= 1
                left += 1
            res += (right - left + 1)
        return len(nums) * (len(nums) + 1) // 2 - res