class Solution:
    def subarraysWithKDistinct(self, nums: List[int], k: int) -> int:
        def subArraysWithAtLeastKDistinct(k):
            left = 0
            res = 0
            map = {}
            for right in range(len(nums)):
                if nums[right] not in map:
                    map[nums[right]] = 1
                else:
                    map[nums[right]] += 1
                while len(map) >= k:
                    map[nums[left]] -= 1
                    if not map[nums[left]]:
                        del map[nums[left]]
                    left += 1
                res += left
            return res
        return subArraysWithAtLeastKDistinct(k) - subArraysWithAtLeastKDistinct(k + 1)