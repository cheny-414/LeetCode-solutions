class Solution {
    public int[][] directions = new int[][] {{0,1}, {-1, 0}, {0, -1}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = countLiveNeighbors(i, j, board);
                int status = board[i][j];
                if (status == 1 && (neighbors < 2 || neighbors > 3)) {
                    board[i][j] = -1;
                } else if (status == 0 && neighbors == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }        
    }

    private int countLiveNeighbors(int row, int col, int[][] board) {
        int neighbors = 0;
        for (int[] dir : directions) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow >= 0 && nextCol >= 0 && nextRow < board.length && nextCol < board[0].length) {
                if (Math.abs(board[nextRow][nextCol]) == 1) {
                    neighbors++;
                }
            }
        }
        return neighbors;
    }
}