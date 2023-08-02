class Solution {
    int[][] grid;
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.grid = grid;
        int answer = 0;

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                dfs(i, 0);
            }
            if (grid[i][n - 1] == 0){
                dfs(i, n - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) {
                dfs(0, i);
            }
            if (grid[m - 1][i] == 0){
                dfs(m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dfs(i, j);
                    answer++;
                }
            }
        }
        return answer;
    }

    private void dfs(int row, int col) {
        grid[row][col] = 2;
        for (int[] dir : directions) {
            int nextrow = row + dir[0];
            int nextcol = col + dir[1];
            if (nextrow >= 0 && nextrow < grid.length && nextcol >= 0 && nextcol < grid[0].length && grid[nextrow][nextcol] == 0) {
                dfs(nextrow, nextcol);
            }
        }
    }
}