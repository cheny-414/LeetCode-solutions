class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        res = []
        def bellmanFord(start):
            dist = [float('inf')] * n
            dist[start] = 0

            for k in range(n - 1):
                for source, dest, weight in edges:
                    if dist[source] + weight < dist[dest]:
                        dist[dest] = dist[source] + weight
                    if dist[dest] + weight < dist[source]:
                        dist[source] = dist[dest] + weight
            
            return sum(1 for x in dist if x <= distanceThreshold)
        
        smallest = -1
        smallestCount = float('inf')
        for i in range(n):
            count = bellmanFord(i)
            if count <= smallestCount:
                smallest = i
                smallestCount = count
        return smallest