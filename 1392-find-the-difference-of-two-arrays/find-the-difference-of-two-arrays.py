class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        map1 = Counter(nums1)
        map2 = Counter(nums2)
        list1 = set()
        list2 = set()
        for num in nums1:
            if num not in map2.keys() and num not in list1:
                list1.add(num)
        for num in nums2:
            if num not in map1.keys() and num not in list2:
                list2.add(num)
        return [list(list1), list(list2)]