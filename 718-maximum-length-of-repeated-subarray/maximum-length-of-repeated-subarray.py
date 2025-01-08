class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        cache = [[-1] * (len(nums2) + 1) for _ in range(len(nums1) + 1)]
        def longest(p1, p2):
            if p1 == len(nums1) or p2 == len(nums2):
                return 0
            if cache[p1][p2] != -1:
                return cache[p1][p2]
            if nums1[p1] == nums2[p2]:
                cache[p1][p2] = 1 + longest(p1 + 1, p2 + 1)
            else:
                cache[p1][p2] = 0
            longest(p1, p2 + 1)
            longest(p1 + 1, p2)
            return cache[p1][p2]
        longest(0, 0)
        return max(max(row) for row in cache)
                