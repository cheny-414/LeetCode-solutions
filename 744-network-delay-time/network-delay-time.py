class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        delays = [float('inf')] * n
        delays[k - 1] = 0
        pq = [(0, k - 1)]
        adj = defaultdict(list)
        for u, v, w in times:
            adj[u - 1].append((w, v - 1))
        while pq:
            delay, node = heappop(pq)
            for w, v in adj[node]:
                if delays[v] > w + delay:
                    delays[v] = w + delays[node]
                    heappush(pq, (delays[v], v))
        return -1 if max(delays) == float('inf') else max(delays)