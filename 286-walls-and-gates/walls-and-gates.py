class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        dirs = ((0, 1), (1, 0), (0, -1), (-1, 0))
        q = deque()
        steps = 0
        for i in range(len(rooms)):
            for j in range(len(rooms[0])):
                #add gate to queue
                if rooms[i][j] == 0:
                    q.append((i, j))
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                #visit neighbors
                for dir in dirs:
                    nexti = curr[0] + dir[0]
                    nextj = curr[1] + dir[1]
                    if 0 <= nexti < len(rooms) and 0 <= nextj < len(rooms[0]) and rooms[nexti][nextj] == 2**31 - 1:
                        q.append((nexti, nextj))
                        rooms[nexti][nextj] = steps + 1
            steps += 1