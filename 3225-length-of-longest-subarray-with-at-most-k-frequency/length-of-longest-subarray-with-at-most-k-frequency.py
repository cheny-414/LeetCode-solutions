class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        left = 0
        counter = defaultdict(int)
        best = 0
        for right in range(len(nums)):
            counter[nums[right]] += 1
            while left <= right and counter[nums[right]] > k:
                counter[nums[left]] -= 1
                left += 1
            best = max(best, right - left + 1)
        return best