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
        def kSum(k, list_so_far, lastIndex):
            if k == 2:
                twoSum(list_so_far, lastIndex, target - sum(list_so_far))
                return
            for i in range(lastIndex + 1, len(nums)):
                kSum(k - 1, list_so_far + [nums[i]], i)
        nums.sort()
        kSum(4, [], -1)
        return list(res)