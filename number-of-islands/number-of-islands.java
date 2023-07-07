class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        //boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        int ans = 0;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0},};
        for (int i  = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    grid[i][j] = '0';
                    int[] node = {i, j};
                    q.add(node);
                    while (!q.isEmpty()) {
                        int[] coord = q.poll();
                        for (int[] dir : directions) {
                            int nexti = coord[0] + dir[0];
                            int nextj = coord[1] + dir[1];
                            if (nexti >= 0 && nexti < m && nextj >= 0 && nextj < n && grid[nexti][nextj] == '1') {
                                q.add(new int[]{nexti, nextj});
                                grid[nexti][nextj] = '0';
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}