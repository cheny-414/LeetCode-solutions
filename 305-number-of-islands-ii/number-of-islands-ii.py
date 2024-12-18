class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [0] * n
    def find(self, a):
        if self.parent[a] != a:
            self.parent[a] = self.find(self.parent[a])
        return self.parent[a]
    def union(self, a, b) -> bool:
        parent_of_a = self.find(a)
        parent_of_b = self.find(b)
        if parent_of_a == parent_of_b:
            return False
        if self.rank[parent_of_a] < self.rank[parent_of_b]:
            self.parent[parent_of_a] = parent_of_b
        elif self.rank[parent_of_a] > self.rank[parent_of_b]:
            self.parent[parent_of_b] = parent_of_a
        else:
            self.parent[parent_of_a] = parent_of_b
            self.rank[parent_of_b] += 1
        return True
class Solution:
    def numIslands2(self, m: int, n: int, positions: List[List[int]]) -> List[int]:
        board = [[0] * n for _ in range(m)]
        positions_set = set()
        dirs = ((0, 1), (1, 0), (0, -1), (-1, 0))
        uf = UnionFind(m * n)
        islands = 0
        answer = []
        def getIndex(row, col):
            return row * n + col
        for pos in positions:
            row, col = pos
            if (row, col) in positions_set:
                answer.append(islands)
                continue
            positions_set.add((row, col))       
            board[row][col] = 1
            islands += 1
            for di in dirs:
                neighbori = row + di[0]
                neighborj = col + di[1]
                if 0 <= neighbori < m and 0 <= neighborj < n and board[neighbori][neighborj] == 1:
                    connected = uf.union(getIndex(row, col), getIndex(neighbori, neighborj))
                    if connected:
                        islands -= 1
            answer.append(islands)
        return answer