class Solution(object):
    def getLargestOutlier(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        answer = -float('inf')
        total = sum(nums)
        counter = Counter(nums)
        for num in nums:
            diff = total - num
            if diff % 2 or counter[diff // 2] == 0:
                continue
            elif num != diff // 2 or counter[num] > 1:
                answer = max(answer, num)
        return answer