class Solution:
    def shortestDistance(self, maze: List[List[int]], start: List[int], destination: List[int]) -> int:
        #0, 4, left
        #0, 4, down

        #0, 3, right/down
        m, n = len(maze), len(maze[0])
        dir = ((0, 1), (1, 0), (0, -1), (-1, 0))
        visited = [[[False] * 4 for _ in range(n)] for _ in range(m)]
        q = deque()
        for num, di in enumerate(dir):
            nexti, nextj = di[0] + start[0], di[1] + start[1]
            if 0 <= nexti < m and 0 <= nextj < n and maze[nexti][nextj] == 0:
                q.append((start[0], start[1], num))
                visited[start[0]][start[1]][num] = True
        steps = 0
        while q:
            size = len(q)
            for k in range(size):
                i, j, num = q.popleft()
                #append neighbors
                neii, neij = i + dir[num][0], j + dir[num][1]
                nexti, nextj = neii + dir[num][0], neij + dir[num][1]
                if 0 <= neii < m and 0 <= neij < n and neii == destination[0] and neij == destination[1]:
                    if nexti < 0 or nexti >= m or nextj < 0 or nextj >= n or maze[nexti][nextj] == 1:
                        return steps + 1
                #only one direction choosable
                if 0 <= neii < m and 0 <= neij < n and maze[neii][neij] == 0:
                    if 0 <= nexti < m and 0 <= nextj < n and maze[nexti][nextj] == 0 and not visited[neii][neij][num]:
                        q.append((neii, neij, num))
                        visited[neii][neij][num] = True
                    else:
                        for order, direction in enumerate(dir):
                            if 0 <= neii + direction[0] < m and 0 <= neij + direction[1] < n and not visited[neii][neij][order] and maze[neii + direction[0]][neij + direction[1]] == 0:
                                q.append((neii, neij, order))
                                visited[neii][neij][order] = True
                                
            steps += 1
        return -1