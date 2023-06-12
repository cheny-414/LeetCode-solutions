class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        int rows = grid.length, cols = grid[0].length;
        int freshOranges = 0;
        int minutes = 0;
        Deque<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) freshOranges++;
                if (grid[i][j] == 2) q.offer(new int[]{i, j, 0});
            }
        }
        if (freshOranges == 0) return 0;

        while (!q.isEmpty()) {
            int[] currBad = q.poll();
            int currRow = currBad[0], currCol = currBad[1], currTime = currBad[2];
            minutes = Math.max(minutes, currTime);
            for (int[] dir : dirs) {
                int targetRow = currBad[0] + dir[0];
                int targetCol = currBad[1] + dir[1];
                if (targetRow < 0 || targetCol < 0 || targetRow > rows - 1 || targetCol > cols - 1) continue;
                if (grid[targetRow][targetCol] != 1) continue;
                grid[targetRow][targetCol] = 2;
                freshOranges--;
                if (freshOranges == 0) return currTime + 1;
                q.offer(new int[]{targetRow, targetCol, currTime + 1});
            }
        }

        return freshOranges > 0 ? -1 : minutes;
    }
}