class Solution {
    int m;
    int n;
    String s;
    String p;
    int[][] dp;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.m = s.length();
        this.n = p.length();
        this.dp = new int[m][n];
        return solve(0, 0);
    }

    private boolean solve(int i, int j) {
        if (i >= m && j >= n) return true;
        if (j >= n) return false;

        boolean canSolve = false;
        boolean hasStar = j < n - 1 && p.charAt(j + 1) == '*';
        boolean isMatch = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (hasStar && isMatch) {
            canSolve = canSolve || solve(i + 1, j); //use star
        }
        if (hasStar) {
            canSolve = canSolve || solve(i, j + 2);
        }
        if (isMatch) {
            canSolve = canSolve || solve(i + 1, j + 1);
        }

        return canSolve;
    }
}