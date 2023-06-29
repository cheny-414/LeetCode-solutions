class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] seen = new boolean[9];
        HashMap<String, boolean[]> grids = new HashMap<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;
                int num = Integer.valueOf(board[row][col]) - '1';
                String grid = String.valueOf(row / 3) + String.valueOf(col / 3);
                boolean[] nums;
                if (!grids.containsKey(grid)) {
                    nums = new boolean[9];
                    nums[num] = true;
                    grids.put(grid, nums);
                } else {
                    nums = grids.get(grid);
                    if (nums[num]) {
                        return false;
                    } else {
                        nums[num] = true;
                        grids.put(grid, nums);
                    }
                }
                if (!seen[num]) {
                    seen[num] = true;
                } else {
                    return false;
                }
            }
            Arrays.fill(seen, false);
        }

        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                if (board[row][col] == '.') continue;
                int num = Integer.valueOf(board[row][col]) - '1';
                if (!seen[num]) {
                    seen[num] = true;
                } else {
                    return false;
                }
            }
            Arrays.fill(seen, false);
        }
        return true;
    }
}