class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0] * n
    def find(self, a):
        if self.parent[a] != a:
            self.parent[a] = self.find(self.parent[a])
        return self.parent[a]
    def union(self, a, b):
        parent_of_a = self.find(a)
        parent_of_b = self.find(b)
        if parent_of_a == parent_of_b:
            return False
        if self.rank[parent_of_a] < self.rank[parent_of_b]:
            self.parent[parent_of_a] = parent_of_b
        elif self.rank[parent_of_a] > self.rank[parent_of_b]:
            self.parent[parent_of_b] = parent_of_a
        else:
            self.parent[parent_of_b] = parent_of_a
            self.rank[parent_of_a] += 1
        return True
class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        uf = UnionFind(len(graph))
        for node, neighbors in enumerate(graph):
            for nei in neighbors:
                if uf.find(node) == uf.find(nei):
                    return False
            for nei in neighbors:
                uf.union(nei, neighbors[0])
        return True
            