class Solution {
    int[][] grid;
    int[][] dp;
    int m;
    int n;
    int[][] dirs = new int[][] {{-1, 1}, {0, 1}, {1, 1}};
    public int maxMoves(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, helper(i, 0));
        }
        return max;
    }

    private int helper(int row, int col) {
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int max = 0;
        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow >= 0 && nextRow < m && nextCol < n && grid[nextRow][nextCol] > grid[row][col]) {
                max = Math.max(max, 1 + helper(nextRow, nextCol));
            }
        }
        return dp[row][col] = max;
    }
}