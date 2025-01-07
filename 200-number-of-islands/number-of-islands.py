class UnionFind:
    def __init__(self):
        self.rank = {}
        self.parent = {}
    def find(self, x):
        if x not in self.rank:
            self.rank[x] = 0
            self.parent[x] = x
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    def union(self, a, b):
        a_parent = self.find(a)
        b_parent = self.find(b)
        if a_parent == b_parent:
            return False
        if self.rank[a_parent] < self.rank[b_parent]:
            self.parent[a_parent] = b_parent
        elif self.rank[a_parent] > self.rank[b_parent]:
            self.parent[b_parent] = a_parent
        else:
            self.parent[b_parent] = a_parent
            self.rank[a_parent] += 1
        return True

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        uf = UnionFind()
        m = len(grid)
        n = len(grid[0])
        total = 0
        connections = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '0': continue
                total += 1
                curr = i * n + j
                #grid[i][j] = 0
                #uf.find(curr)
                for neighbor in ((i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)):
                    if 0 <= neighbor[0] < m and 0 <= neighbor[1] < n and grid[neighbor[0]][neighbor[1]] == '1':
                        nei = neighbor[0] * n + neighbor[1]
                        if uf.union(curr, nei):
                            connections += 1
        return total - connections

        #1, 0, 1, 1, 1
        #1, 0, 1, 0, 1
        #1, 1, 1, 0, 1
        