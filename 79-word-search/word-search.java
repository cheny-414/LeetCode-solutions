class Solution {
    char[][] board;
    int m;
    int n;
    String word;
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.word = word;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int row, int col, int index) {
        if (index >= word.length()) return true;
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != word.charAt(index)) {
            return false;
        }

        boolean ret = false;
        board[row][col] = '%';
        for (int[] dir : directions) {
            if (backtrack(row + dir[0], col + dir[1], index + 1)) {
                ret = true;
                break;
            }
        }

        board[row][col] = word.charAt(index);
        return ret;
    }
}