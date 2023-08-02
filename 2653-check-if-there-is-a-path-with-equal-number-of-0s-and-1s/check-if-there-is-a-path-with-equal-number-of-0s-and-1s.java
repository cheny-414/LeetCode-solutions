class Solution {
    public boolean isThereAPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Map<String, Boolean> map = new HashMap<>();

        if ((m + n) % 2 == 0) return false;

        return helper(map, grid, 0, 0, 0);
    }

    private boolean helper(Map<String, Boolean> map, int[][] grid, int row, int col, int diff) {
        if (row >= grid.length || col >= grid[0].length) {
            return false;
        }
        if (grid[row][col] == 1) {
            diff++;
        } else {
            diff--;
        }
        String key = row + " " + col + " " + diff + " ";
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (row == grid.length - 1 && col == grid[0].length - 1 && diff == 0) {
            return true;
        }

        boolean hasPath = helper(map, grid, row + 1, col, diff) || helper(map, grid, row, col + 1, diff);
        map.put(key, hasPath);
        return hasPath;
    }
}