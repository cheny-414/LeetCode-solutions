class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        rank = {}
        graph = defaultdict(list)
        conn_set = set()

        for i in range(n):
            rank[i] = None

        for edge in connections:
            u, v = edge[0], edge[1]
            graph[u].append(v)
            graph[v].append(u)
            conn_set.add((min(u, v), max(u, v)))

        def dfs(node, discovery_rank):
            if rank[node]:
                return rank[node]
            rank[node] = discovery_rank
            min_rank = discovery_rank

            for neighbor in graph[node]:
                if rank[neighbor] and rank[neighbor] == discovery_rank - 1:
                    continue
                recursive_rank = dfs(neighbor, discovery_rank + 1)
                if recursive_rank <= discovery_rank:
                    conn_set.remove((min(node, neighbor), max(node, neighbor)))
                min_rank = min(min_rank, recursive_rank)
            return min_rank

        dfs(0, 0)
        return list(conn_set)