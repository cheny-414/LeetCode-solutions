class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = ((0, 1), (1, 0), (0, -1), (-1, 0))
        q = deque([(0, 0, 0)]) # (row, col, elims)
        visited = set([(0, 0, 0)])
        steps = 0
        while q:
            size = len(q)
            for i in range(size):
                currRow, currCol, elims = q.popleft()
                if currRow == m - 1 and currCol == n - 1:
                    return steps
                for direction in dirs:
                    nextRow = currRow + direction[0]
                    nextCol = currCol + direction[1]
                    if 0 <= nextRow < m and 0 <= nextCol < n:
                        nextElim = elims + grid[nextRow][nextCol]
                        nextState = (nextRow, nextCol, nextElim)
                        if nextElim <= k and nextState not in visited:
                            visited.add(nextState)
                            q.append(nextState)
            steps += 1
        return -1