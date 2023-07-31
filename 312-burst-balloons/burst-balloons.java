class Solution {
    public int maxCoins(int[] nums) {
        int[] balloons = new int[nums.length + 2];
        int n = balloons.length;
        //pad left and right with a 1
        balloons[0] = 1;
        balloons[n - 1] = 1;
        for (int i = 1; i < n - 1; i++) {
            balloons[i] = nums[i - 1];
        }

        //divide and conquer
        int[][] dp = new int[n][n];
        return burst(dp, balloons, 0, n - 1);
    }

    private int burst(int[][] dp, int[] balloons, int leftBound, int rightBound) {
        //left and right bounds are exclusive (not burstable)
        if (leftBound + 1 >= rightBound) return 0;
        if (dp[leftBound][rightBound] > 0) return dp[leftBound][rightBound];
        int answer = 0;
        for (int i = leftBound + 1; i < rightBound; i++) {
            int maxValue = balloons[leftBound] * balloons[i] * balloons[rightBound] + burst(dp, balloons, leftBound, i) + burst(dp, balloons, i, rightBound);
            answer = Math.max(answer, maxValue);
        }
        dp[leftBound][rightBound] = answer;
        return answer;
    }
}