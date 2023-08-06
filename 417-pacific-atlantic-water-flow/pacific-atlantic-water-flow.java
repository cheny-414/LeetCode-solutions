class Solution {
    int[][] p_visited;
    int[][] a_visited;
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m;
    int n;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> answer = new ArrayList<>();
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        p_visited = new int[m][n];
        a_visited = new int[m][n];

        for (int j = 0; j < n; j++) {
            dfs(0, j, true);
            dfs(m - 1, j, false);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, 0, true);
            dfs(i, n - 1, false);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p_visited[i][j] == 1 && a_visited[i][j] == 1) {
                    List<Integer> point = List.of(i, j);
                    answer.add(point);
                }
            }
        }
        return answer;
    }

    private void dfs(int row, int col, boolean pacific) {
        if (pacific && p_visited[row][col] == 1) return;
        if (!pacific && a_visited[row][col] == 1) return;
        if (pacific) {
            p_visited[row][col] = 1;
        } else {
            a_visited[row][col] = 1;
        }

        for (int[] direction : directions) {
            int nexti = row + direction[0];
            int nextj = col + direction[1];
            if (nexti >= 0 && nexti < m && nextj >= 0 && nextj < n && heights[nexti][nextj] >= heights[row][col]) {
                dfs(nexti, nextj, pacific);
            }
        }
    }
}