class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        counter = Counter(tuple(row) for row in grid)
        count = 0
        n = len(grid)
        for c in range(n):
            col = [grid[i][c] for i in range(n)]
            count += counter[tuple(col)]
        return count