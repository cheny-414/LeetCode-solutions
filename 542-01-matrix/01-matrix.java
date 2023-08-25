class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] answer = new int[m][n];
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> q = new ArrayDeque<>();
        int distance = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    answer[i][j] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (answer[curr[0]][curr[1]] > 0) continue;
                answer[curr[0]][curr[1]] = distance;
                mat[curr[0]][curr[1]] = 0;
                for (int[] dir : dirs) {
                    int nexti = curr[0] + dir[0];
                    int nextj = curr[1] + dir[1];
                    if (nexti >= 0 && nexti < m && nextj >= 0 && nextj < n && mat[nexti][nextj] == 1) {
                        q.add(new int[]{nexti, nextj});
                    }
                }
            }
            distance++;
        }
        return answer;
    }
}