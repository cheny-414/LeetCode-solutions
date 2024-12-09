class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [0] * len(nums)
        suffix = [0] * len(nums)
        result = []
        prod = 1
        for i in range(len(nums)):
            prefix[i] = prod
            prod = prod * nums[i]
        prod = 1
        for i in reversed(range(len(nums))):
            suffix[i] = prod
            prod = prod * nums[i]
        
        for i in range(len(nums)):
            result.append(prefix[i] * suffix[i])
        return result
