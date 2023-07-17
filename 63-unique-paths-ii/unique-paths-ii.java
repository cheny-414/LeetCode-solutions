class Solution {
    int m;
    int n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.m = obstacleGrid.length;
        this.n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = helper(0, 0, obstacleGrid, dp);
        return ans;
    }

    private int helper(int row, int col, int[][] obstacleGrid, int[][] dp) {
        if (row >= m || col >= n) return 0;
        if (dp[row][col] != -1) return dp[row][col];
        if (obstacleGrid[row][col] == 1) {
            dp[row][col] = 0;
            return 0;
        }
        if (row == m - 1 && col == n - 1) return dp[row][col] = 1;
        int down = helper(row + 1, col, obstacleGrid, dp);
        int right = helper(row, col + 1, obstacleGrid, dp);
        dp[row][col] = down + right;
        return dp[row][col];
    }
}