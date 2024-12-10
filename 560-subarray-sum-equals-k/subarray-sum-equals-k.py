class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefixSum = defaultdict(int)
        prefixSum[0] = 1
        runningSum = 0
        result = 0
        for num in nums:
            runningSum += num
            target = runningSum - k
            if target in prefixSum.keys():
                result += prefixSum[target]
            if runningSum in prefixSum.keys():
                prefixSum[runningSum] += 1
            else:
                prefixSum[runningSum] = 1
        return result