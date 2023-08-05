class Solution {
    int[] nums;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        this.nums = nums;
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(solve(dp1, 0, 0, nums.length - 2), solve(dp2, 1, 1, nums.length - 1));
    }

    private int solve(int[] dp, int start, int left, int right) {
        if (start > right) {
            return 0;
        }
        if (dp[start] != -1) return dp[start];

        dp[start] = Math.max(solve(dp, start + 1, left, right), solve(dp, start + 2, left, right) + nums[start]);
        return dp[start];
    }
}