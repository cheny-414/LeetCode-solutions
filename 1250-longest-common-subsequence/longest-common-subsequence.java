class Solution {
    String text1;
    String text2;
    int[][] dp;
    int m;
    int n;
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        this.m = text1.length();
        this.n = text2.length();
        this.dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(0, 0);
    }

    private int helper(int i, int j) {
        if (i >= m || j >= n) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int lcs = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            lcs = 1 + helper(i + 1, j + 1);
        } else {
            lcs = Math.max(helper(i + 1, j), helper(i, j + 1));
        }
        return dp[i][j] = lcs;
    }
}