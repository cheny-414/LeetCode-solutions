class Solution:
    def findIntersectionValues(self, nums1: List[int], nums2: List[int]) -> List[int]:
        map1 = defaultdict(int)
        map2 = defaultdict(int)
        res1 = 0
        res2 = 0
        for num in nums1:
            map1[num] += 1
        for num in nums2:
            map2[num] += 1
        for key in map2:
            if map2[key]:
                res1 += map1[key]
        for key in map1:
            if map1[key]:
                res2 += map2[key]
        return [res1, res2]