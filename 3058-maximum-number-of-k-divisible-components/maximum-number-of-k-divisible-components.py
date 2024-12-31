class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:
        adj = defaultdict(list)
        for edge in edges:
            adj[edge[0]].append(edge[1])
            adj[edge[1]].append(edge[0])
        components = 0
        def dfs(node, parent):
            nonlocal components
            if len(adj[node]) == 1 and adj[node] == parent and values[node] % k == 0:
                components += 1
                return 0
            else:
                total = values[node]
                for neighbor in adj[node]:
                    if neighbor != parent:
                        total += dfs(neighbor, node)
                if total % k == 0:
                    components += 1
                    return 0
                else:
                    return total
        dfs(0, None)
        return components
