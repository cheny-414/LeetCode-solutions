class Solution {
    public int[][] minScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowMaxes = new int[m];
        int[] colMaxes = new int[n];
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> grid[a.getKey()][a.getValue()] - grid[b.getKey()][b.getValue()]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.add(new Pair<>(i, j));
            }
        }

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pos = pq.poll();
            int row = pos.getKey();
            int col = pos.getValue();
            grid[row][col] = Math.max(rowMaxes[row], colMaxes[col]) + 1;
            rowMaxes[row] = grid[row][col];
            colMaxes[col] = grid[row][col];
        }
        return grid;
    }
}