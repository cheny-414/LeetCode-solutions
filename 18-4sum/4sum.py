class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = set()
        quad = []
        def twoSum(start, target):
            map = set()
            for i in range(start, len(nums)):
                curr = nums[i]
                diff = target - curr
                if diff in map:
                    fourSum = quad + [curr, diff]
                    res.add(tuple(sorted(fourSum)))
                map.add(curr)
        def kSum(k, start, target):
            if k == 2:
                twoSum(start, target)
                return
            for i in range(start, len(nums) - k + 1):
                if i > start and nums[i] == nums[i - 1]:
                    continue
                quad.append(nums[i])
                kSum(k - 1, i + 1, target - nums[i])
                quad.pop()
        kSum(4, 0, target)
        return list(res)