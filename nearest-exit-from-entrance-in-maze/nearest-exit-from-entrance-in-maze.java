class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length, cols = maze[0].length;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Deque<int[]> q = new ArrayDeque<>();
        int startRow = entrance[0], startCol = entrance[1];
        maze[startRow][startCol] = '+';
        q.offer(new int[]{startRow, startCol, 0});

        while (!q.isEmpty()) {
            int[] currPos = q.poll();
            int currRow = currPos[0], currCol = currPos[1], currDist = currPos[2];

            for (int[] dir : dirs) {
                int nextRow = currRow + dir[0], nextCol = currCol + dir[1];

                if (nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols && maze[nextRow][nextCol] == '.') {
                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1) {
                        return currDist + 1;
                    }
                    maze[nextRow][nextCol] = '+';
                    q.offer(new int[]{nextRow, nextCol, currDist + 1});
                }
            }
        }

        return -1;
    }
}