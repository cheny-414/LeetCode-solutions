class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        adj = defaultdict(list)
        for u, v, w in edges:
            adj[u].append((v, w))
            adj[v].append((u, w))
        def dijkstra(start):
            dist = [float('inf')] * n
            dist[start] = 0
            pq = [(0, start)]

            while pq:
                cost, node = heappop(pq)
                for nei, w in adj[node]:
                    if dist[nei] > w + cost:
                        dist[nei] = w + cost
                        heappush(pq, (dist[nei], nei))
            return sum(1 for x in dist if x <= distanceThreshold)
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
        def floydWarshall():
            dist = [[float('inf')] * n for _ in range(n)]
            for i in range(n):
                dist[i][i] = 0
            for u, v, w in edges:
                dist[u][v] = w
                dist[v][u] = w
            for k in range(n):
                for i in range(n):
                    for j in range(n):
                        dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
            return dist

        dist = floydWarshall()
        smallest = -1
        smallestCount = float('inf')
        for i in range(n):
            #count = dijkstra(i)
            #count = bellmanFord(i)
            count = sum(1 for x in dist[i] if x <= distanceThreshold)
            if count <= smallestCount:
                smallest = i
                smallestCount = count
        return smallest