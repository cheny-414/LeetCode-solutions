class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long answer = 0;
        long[][][] dp = new long[n][n+1][2]; //startIndex, length, (range, max)

        for (int i = 0; i < n; i++) {
            dp[i][1][1] = nums[i];
        }
        for (int length = 2; length <= n; length++) {
            for (int start = 0; start + length - 1 < n; start++) {
                int end = start + length - 1;
                long lastMax = dp[start][length - 1][1];
                long lastMin = dp[start][length - 1][1] - dp[start][length - 1][0];
                long value = nums[end];
                if (value > lastMax) {
                    dp[start][length][0] = dp[start][length - 1][0] + (value - lastMax);
                    dp[start][length][1] = value;
                } else if (value < lastMin) {
                    dp[start][length][1] = lastMax;
                    dp[start][length][0] = lastMax - value;
                } else {
                    dp[start][length][0] = dp[start][length - 1][0];
                    dp[start][length][1] = lastMax;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                answer += dp[i][j][0];
            }
        }
        return answer;
    }
}