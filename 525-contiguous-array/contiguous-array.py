class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        runningSum = 0
        diffs = {}
        for i, num in enumerate(nums):
            runningSum += num if num == 1 else -1
            if runningSum not in diffs:
                diffs[runningSum] = []
                diffs[runningSum].append(i)
            elif len(diffs[runningSum]) == 1:
                diffs[runningSum].append(i)
            else:
                diffs[runningSum][-1] = i
        maxSize = 0
        for key, indices in diffs.items():
            if len(indices) > 1:
                maxSize = max(maxSize, indices[1] - indices[0])
            if key == 0:
                maxSize = max(maxSize, max(indices) + 1)
        return maxSize
        #-1, 0, -1, 0