class Solution {
    int m;
    int n;
    String s;
    String p;
    int[][] dp; //1 is true, 2 is false
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.m = s.length();
        this.n = p.length();
        this.dp = new int[m + 1][n + 1];
        return solve(0, 0);
    }

    private boolean solve(int i, int j) {
        if (i >= m && j >= n) return true;
        if (j >= n) return false;

        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }

        boolean canSolve = false;
        boolean hasStar = j < n - 1 && p.charAt(j + 1) == '*';
        boolean isMatch = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (hasStar && isMatch) {
            canSolve |= solve(i + 1, j); //use star
        }
        if (hasStar) {
            canSolve |= solve(i, j + 2); //not use star
        }
        if (isMatch) {
            canSolve |= solve(i + 1, j + 1); //move to next character
        }
        
        dp[i][j] = canSolve ? 1 : 2;
        return canSolve;
    }
}