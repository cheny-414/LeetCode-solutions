class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        highest = 0
        height = 0
        for num in gain:
            height += num
            highest =max(highest, height)
        return highest