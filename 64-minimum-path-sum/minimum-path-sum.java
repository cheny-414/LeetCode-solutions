class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0, grid, dp);
    }

    private int helper(int row, int col, int[][] grid, int[][] dp) {
        if (row == grid.length - 1 && col == grid[0].length - 1) return grid[row][col];
        if (dp[row][col] != -1) return dp[row][col];
        int curr = grid[row][col];
        int down = row == grid.length - 1 ? Integer.MAX_VALUE : helper(row + 1, col, grid, dp);
        int right = col == grid[0].length - 1 ? Integer.MAX_VALUE : helper(row, col + 1, grid, dp);

        dp[row][col] = curr + Math.min(down, right);
        return dp[row][col];
    }
}