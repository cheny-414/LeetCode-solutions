class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        dirs = ((0,1), (1,0), (0,-1), (-1,0))
        days = 0
        fresh = 0
        q = deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    q.append((i, j))
                elif grid[i][j] == 1:
                    fresh += 1
        if not fresh: return 0
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for di in dirs:
                    new_pos = (curr[0] + di[0], curr[1] + di[1])
                    if 0 <= new_pos[0] < m and 0 <= new_pos[1] < n and grid[new_pos[0]][new_pos[1]] == 1:
                        q.append(new_pos)
                        grid[new_pos[0]][new_pos[1]] = 2
                        fresh -= 1
                        if not fresh: return days + 1
            days += 1
        return -1