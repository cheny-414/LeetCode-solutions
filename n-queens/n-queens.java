class Solution {
    int n;
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        ans = new ArrayList<>();
        backtrack(0, new ArrayList<>(), new HashSet<>(), new HashSet<>());
        return ans;
    }

    private void backtrack(int row, List<Integer> cols, Set<Integer> diags, Set<Integer> antis) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                int col = cols.get(i);
                for (int j = 0; j < col; j++) {
                    sb.append('.');
                }
                sb.append('Q');
                for (int j = col + 1; j < n; j++) {
                    sb.append('.');
                }
                solution.add(sb.toString());
            }
            ans.add(new ArrayList<>(solution));
        }

        for (int col = 0; col < n; col++) {
            int diag = row - col;
            int anti = row + col;
            if (!cols.contains(col) && !diags.contains(diag) && !antis.contains(anti)) {
                cols.add(col);
                diags.add(diag);
                antis.add(anti);
                backtrack(row + 1, cols, diags, antis);
                cols.remove(cols.size() - 1);
                diags.remove(diag);
                antis.remove(anti);
            }
        }
    }
}