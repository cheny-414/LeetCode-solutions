class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        def getSwaps(num):
            count = nums.count(num)
            nonNums = 0
            for i in range(count):
                if nums[i] != num:
                    nonNums += 1
            minSwaps = nonNums
            for i in range(count, len(nums)):
                if nums[i - count] != num:
                    nonNums -= 1
                if nums[i] != num:
                    nonNums += 1
                minSwaps = min(minSwaps, nonNums)
            return minSwaps
        return min(getSwaps(0), getSwaps(1))