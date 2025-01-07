class UnionFind:
    def __init__(self, n):
        self.rank = [0] * n
        self.parent = list(range(n))
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
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        uf = UnionFind(n)
        connections = 0
        for edge in edges:
            if uf.union(edge[0], edge[1]):
                connections += 1
        return n - connections