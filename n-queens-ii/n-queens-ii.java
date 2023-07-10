class Solution {
    int size;
    int solutions;

    public int totalNQueens(int n) {
        size = n;
        solutions = 0;
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return solutions;
    }

    private void backtrack(int row, Set<Integer> diag, Set<Integer> anti, Set<Integer> cols) {
        if (row == size) {
            solutions++;
        }

        for (int col = 0; col < size; col++) {
            int currDiag = row - col;
            int currAnti = row + col;
            if (!cols.contains(col) && !diag.contains(currDiag) && !anti.contains(currAnti)) {
                cols.add(col);
                diag.add(currDiag);
                anti.add(currAnti);
                backtrack(row + 1, diag, anti, cols);
                cols.remove(col);
                diag.remove(currDiag);
                anti.remove(currAnti);
            }
        }
    }
}