class Solution {
    String s1, s2, s3;
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, 0);
    }

    private boolean helper(int i, int j) {
        if (i == s1.length() && j == s2.length()) return true;

        if (dp[i][j] != -1) return dp[i][j] == 1;

        if (i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(i + j)) {
            dp[i][j] = (helper(i + 1, j) | helper(i, j + 1)) ? 1 : 0;
        } else if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            dp[i][j] = helper(i + 1, j) ? 1 : 0;
        } else if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            dp[i][j] = helper(i, j + 1) ? 1 : 0;
        } else {
            dp[i][j] = 0;
        }
        return dp[i][j] == 1;
    }
}