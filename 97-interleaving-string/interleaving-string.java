class Solution {
    String s1, s2, s3;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        boolean result = helper(0, 0, dp);
        return result;
    }

    private boolean helper(int i, int j, int[][] dp) {
        if (i == s1.length() && j == s2.length()) return true;

        if (dp[i][j] != -1) return dp[i][j] == 1;

        boolean choose_s1 = false, choose_s2 = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            choose_s1 = helper(i + 1, j, dp);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            choose_s2 = helper(i, j + 1, dp);
        }
        dp[i][j] = choose_s1 | choose_s2 ? 1 : 0;
        return dp[i][j] == 1;
    }
}