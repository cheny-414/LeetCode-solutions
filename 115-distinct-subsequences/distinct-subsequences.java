class Solution {
    int[][] dp;
    String s;
    String t;
    int m;
    int n;
    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();
        this.s = s;
        this.t = t;
        dp = new int[m + 1][n + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(m - 1, n - 1);
    }

    private int solve(int index1, int index2) {
        if (index2 < 0) return 1;
        if (index1 < 0) return 0;
        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        int answer = solve(index1 - 1, index2);
        if (s.charAt(index1) == t.charAt(index2)) {
            answer += solve(index1 - 1, index2 - 1);
        }
        return dp[index1][index2] = answer;
    }
}