class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m = len(board)
        n = len(board[0])
        q = deque()
        dirs = ((0, 1), (1, 0), (0, -1), (-1, 0))
        for i in range(m):
            for j in (0, n - 1):
                if board[i][j] == 'O':
                    q.append((i, j))
                    board[i][j] = '-'
        for j in range(n):
            for i in (0, m - 1):
                if board[i][j] == 'O':
                    q.append((i, j))
                    board[i][j] = '-'
        while q:
            curr = q.popleft()
            for dir in dirs:
                nexti = curr[0] + dir[0]
                nextj = curr[1] + dir[1]
                if 0 <= nexti < m and 0 <= nextj < n and board[nexti][nextj] == 'O':
                    q.append((nexti, nextj))
                    board[nexti][nextj] = '-'
        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                elif board[i][j] == '-':
                    board[i][j] = 'O'
        return