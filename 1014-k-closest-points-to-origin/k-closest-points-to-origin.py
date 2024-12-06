class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        distance = [a*a + b*b for a, b in points]
        def quickselect(k, left, right):
            if left < right:
                pivot = partition(left, right)
                if pivot == k:
                    return points[:k]
                if pivot < k:
                    quickselect(k, pivot + 1, right)
                else:
                    quickselect(k, left, pivot - 1)

        def partition(left, right):
            pivot = distance[right]
            p1 = left
            for p2 in range(left, right):
                if distance[p2] <= pivot:
                    distance[p2], distance[p1] = distance[p1], distance[p2]
                    points[p2], points[p1] = points[p1], points[p2]
                    p1 += 1
            distance[right], distance[p1] = distance[p1], distance[right]
            points[right], points[p1] = points[p1], points[right]
            return p1
        quickselect(k, 0, len(points) - 1)
        return points[:k]