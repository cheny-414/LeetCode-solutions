class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0},};
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        //traverse first col
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
        }

        //last col
        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                bfs(board, i, n-1);
            }
        }

        //first row
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                bfs(board, 0, i);
            }
        }

        //last row
        for (int i = 0; i < n; i++) {
            if (board[m - 1][i] == 'O') {
                bfs(board, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {i, j});
        board[i][j] = 'V';
        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int[] dir : directions) {
                int nexti = node[0] + dir[0];
                int nextj = node[1] + dir[1];
                if (nexti >= 0 && nexti < m && nextj >= 0 && nextj < n && board[nexti][nextj] == 'O') {
                    q.add(new int[]{nexti, nextj});
                    board[nexti][nextj] = 'V';
                }
            }
        }
    }
}