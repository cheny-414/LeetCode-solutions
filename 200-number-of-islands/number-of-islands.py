class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def explore(i, j):
            if (i < 0 or j < 0 or i >= m or j >= n or grid[i][j] != '1' or visited[i][j] == True): return
            visited[i][j] = True
            explore(i - 1, j)
            explore(i + 1, j)
            explore(i, j - 1)
            explore(i, j + 1)
        m = len(grid)
        n = len(grid[0])
        numIslands = 0
        visited =[[False] * n for i in range(m)]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1' and visited[i][j] == False:
                    numIslands += 1
                    explore(i, j)
        return numIslands
        