class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        q = deque([entrance])
        m = len(maze)
        n = len(maze[0])
        visited = [[0] * n for _ in range(m)]
        steps = 0
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                #visited[curr[0]][curr[1]] = 1
                if (curr[0] != entrance[0] or curr[1] != entrance[1]) and (curr[0] == 0 or curr[0] == m - 1 or curr[1] == 0 or curr[1] == n - 1):
                    return steps
                for dir in ((1,0), (0,1), (-1,0), (0,-1)):
                    new_pos = (curr[0] + dir[0], curr[1] + dir[1])
                    if 0 <= new_pos[0] < m and 0 <= new_pos[1] < n and maze[new_pos[0]][new_pos[1]] == '.' and not visited[new_pos[0]][new_pos[1]]:
                        q.append(new_pos)
                        visited[new_pos[0]][new_pos[1]] = 1
            steps += 1
        return -1
