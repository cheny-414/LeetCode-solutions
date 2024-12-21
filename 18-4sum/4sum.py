class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = set()
        def twoSum(sofar, last, targetR):
            map = set()
            for i in range(last + 1, len(nums)):
                curr = nums[i]
                diff = targetR - curr
                if diff in map:
                    fourSum = sofar + [curr] + [diff]
                    res.add(tuple(sorted(fourSum)))
                map.add(curr)
        
        for i in range(0, len(nums)):
            for j in range(i + 1, len(nums)):
                twoSum([nums[i], nums[j]], j, target - nums[i] - nums[j])
        return list(res)