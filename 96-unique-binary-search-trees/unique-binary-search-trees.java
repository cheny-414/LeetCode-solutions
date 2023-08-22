class Solution {
    int[][] dp;
    public int numTrees(int n) {
        dp = new int[n + 1][n + 1];
        return arrangements(1, n);
    }

    private int arrangements(int start, int end) {
        if (start >= end) return 1;
        if (dp[start][end] != 0) return dp[start][end];
        int answer = 0;
        for (int i = start; i <= end; i++) {
            int left = arrangements(start, i - 1);
            int right = arrangements(i + 1, end);
            answer += left * right;
        }
        return dp[start][end] = answer;
    }
}