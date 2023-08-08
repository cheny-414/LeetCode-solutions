class Solution {
    int[][] dp;
    String s;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        this.s = s;
        dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return solve(0, n - 1);
    }

    private int solve(int left, int right) {
        if (left == right) return 1;
        //if (left + 1 == right && s.charAt(left) == s.charAt(right)) return 2;
        if (left > right) return 0;
        if (dp[left][right] != -1) return dp[left][right];

        int answer = 0;
        if (s.charAt(left) == s.charAt(right)) {
            int inside = solve(left + 1, right - 1);
            if (inside >= 0) {
                answer = inside + 2;
            }
        } else {
            answer = Math.max(solve(left + 1, right), solve(left, right - 1));
        }
        return dp[left][right] = answer;
    }
}