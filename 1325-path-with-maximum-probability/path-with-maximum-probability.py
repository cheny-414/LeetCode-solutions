class Solution:
    def maxProbability(self, n: int, edges: List[List[int]], succProb: List[float], start_node: int, end_node: int) -> float:
        pq = [(-1, start_node)]
        probs = [0] * n
        probs[start_node] = 1
        adj = defaultdict(list)
        visited = [False] * n
        for i, edge in enumerate(edges):
            adj[edge[0]].append((succProb[i], edge[1]))
            adj[edge[1]].append((succProb[i], edge[0]))
        while pq:
            prob, node = heappop(pq)
            # if node == end_node:
            #     return prob
            if -prob < probs[node]:
                continue
            for nextProb, neighbor in adj[node]:
                overallProb = -prob * nextProb
                if probs[neighbor] < overallProb:
                    probs[neighbor] = overallProb
                    heappush(pq, (-overallProb, neighbor))
        return probs[end_node]