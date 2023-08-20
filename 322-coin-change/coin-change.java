class Solution {
    int[] coins;
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int result = solve(amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int solve(int amount) {
        if (amount == 0) return 0;
        if (dp[amount] != -1) return dp[amount];
        int minNeeded = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int remainingNeeded = solve(amount - coin);
                if (remainingNeeded != Integer.MAX_VALUE) {
                    minNeeded = Math.min(1 + remainingNeeded, minNeeded);
                }
            }
        }
        dp[amount] = minNeeded;
        return dp[amount];
    }
}