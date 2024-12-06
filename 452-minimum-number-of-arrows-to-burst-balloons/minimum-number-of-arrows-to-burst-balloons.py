class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key = lambda x: x[1])

        arrows = 0
        i = 0
        while i < len(points):
            point = points[i]
            end = point[1]
            while i + 1 < len(points) and points[i + 1][0] <= end:
                i += 1
            arrows += 1
            i += 1
        return arrows
         