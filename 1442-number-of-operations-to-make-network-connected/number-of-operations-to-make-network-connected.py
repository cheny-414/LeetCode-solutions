class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        if len(connections) < n - 1:
            return -1
        visited = [0 for _ in range(n)]
        adj = defaultdict(list)
        ccnum = 0
        def explore(node, ccnum):
            visited[node] = ccnum
            for neighbor in adj[node]:
                if not visited[neighbor]:
                    explore(neighbor, ccnum)

        for a, b in connections:
            if not adj[a]:
                adj[a] = [b]
            else:
                adj[a].append(b)
            if not adj[b]:
                adj[b] = [a]
            else:
                adj[b].append(a)
        for i in range(n):
            if not visited[i]:
                ccnum += 1
                explore(i, ccnum)
                
        
        return ccnum - 1