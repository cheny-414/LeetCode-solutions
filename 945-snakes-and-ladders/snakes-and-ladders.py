class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)
        goal = n ** 2
        def getcoord(num):
            row = n - 1 - ((num - 1) // n)
            col = (num - 1) % n if (num - 1) // n % 2 == 0 else n - 1 - (num - 1) % n
            return (row, col)
        q = deque([1])
        steps = 0
        visited = [0] * (n**2 + 1)
        visited[1] = 1
        while q:
            size = len(q)
            for j in range(size):
                curr = q.popleft()
                if curr == goal: return steps
                for i in range(1, 7):
                    # get destination
                    dest = curr + i
                    if dest > goal: continue
                    coord = getcoord(dest)
                    if board[coord[0]][coord[1]] != -1:
                        dest = board[coord[0]][coord[1]]
                    if not visited[dest]:
                        q.append(dest)
                        visited[dest] = 1
            steps += 1
        return -1