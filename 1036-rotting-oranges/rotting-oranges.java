class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int minutes = -1;
        int freshCount = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        if (freshCount == 0) return 0;

        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                if (grid[curr[0]][curr[1]] == 3) continue;
                if (grid[curr[0]][curr[1]] == 1) freshCount--;
                if (freshCount == 0) return minutes;
                grid[curr[0]][curr[1]] = 3;
                List<int[]> neighbors = getNeighbors(curr, grid);
                for (int[] neighbor : neighbors) {
                    if (grid[neighbor[0]][neighbor[1]] == 1) {
                        q.add(neighbor);
                    }
                }
            }
        }
        return freshCount == 0 ? minutes : -1;
    }

    private List<int[]> getNeighbors(int[] curr, int[][] grid) {
        List<int[]> result = new ArrayList<>();
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] dir : directions) {
            int nexti = curr[0] + dir[0];
            int nextj = curr[1] + dir[1];
            if (nexti < grid.length && nexti >= 0 && nextj < grid[0].length && nextj >= 0) {
                result.add(new int[] {nexti, nextj});
            }
        }
        return result;
    }
}