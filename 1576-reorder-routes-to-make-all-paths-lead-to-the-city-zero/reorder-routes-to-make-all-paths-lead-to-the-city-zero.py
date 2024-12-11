class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        adj = {}
        changes = 0
        visited = [0] * n
        for conn in connections:
            a, b  = conn
            if a not in adj:
                adj[a] = set()
            if b not in adj:
                adj[b] = set()
            adj[b].add(a)
            adj[a].add(-b)
        def dfs(city):
            nonlocal changes
            visited[city] = 1
            for neighbor in adj[city]:
                if neighbor < 0 and not visited[-neighbor]:
                    changes += 1
                    neighbor = -neighbor
                if not visited[abs(neighbor)]:
                    dfs(neighbor)
        dfs(0)
        return changes