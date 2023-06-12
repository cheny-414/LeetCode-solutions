class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<List<Integer>, Integer> rows = new HashMap<>();
        HashMap<List<Integer>, Integer> cols = new HashMap<>();
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                row.add(grid[i][j]);
            }
            rows.put(row, rows.getOrDefault(row, 0) + 1);
        }

        for (int i = 0; i < grid[0].length; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < grid.length; j++) {
                col.add(grid[j][i]);
            }
            cols.put(col, cols.getOrDefault(col, 0) + 1);
        }

        for (List<Integer> list : rows.keySet()) {
            if (cols.get(list) != null) {
                result += rows.get(list) * cols.get(list);
            }
        }
        return result;
    }
}