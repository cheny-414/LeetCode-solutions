class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        dist = [[float('inf')] * n for _ in range(n)]
        for i in range(n):
            dist[i][i] = 0
        for edge in edges:
            dist[edge[0]][edge[1]] = edge[2]
            dist[edge[1]][edge[0]] = edge[2]
        for k in range(n):
            for i in range(n):
                for j in  range(n):
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
        smallestCity = -1
        smallestCount = float('inf')
        for i in range(n):
            count = sum(1 for x in dist[i] if x <= distanceThreshold)
            if count <= smallestCount:
                smallestCity = i
                smallestCount = count
        return smallestCity