class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        dp[0] = 0;
        return helper(coins, amount);
    }

    private int helper(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (dp[amount] != -2) return dp[amount];
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int remainingCoins = helper(coins, amount - coin);
                int coinsNeeded = remainingCoins == -1 ? -1 : remainingCoins + 1;
                if (coinsNeeded != -1 && coinsNeeded < minCoins) {
                    minCoins = coinsNeeded;
                }
            }
        }

        dp[amount] = minCoins == Integer.MAX_VALUE ? -1 : minCoins;
        return dp[amount];
    }
}