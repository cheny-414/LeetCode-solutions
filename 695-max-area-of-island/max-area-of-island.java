class Solution {
    int maxArea = 0;
    int[][] grid;
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (this.grid[i][j] == 0) continue;
                int area = dfs(i, j);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    private int dfs(int row, int col) {
        //if (row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] == 0) return 0;
        grid[row][col] = 0;
        int area = 1;

        for (int[] direction : directions) {
            int nexti = row + direction[0];
            int nextj = col + direction[1];
            if (nexti < grid.length && nextj < grid[0].length && nexti >= 0 && nextj >= 0 && grid[nexti][nextj] == 1) {
                area += dfs(nexti, nextj);
            }
        }
        return area;
    }
}