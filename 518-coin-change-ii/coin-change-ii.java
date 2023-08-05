class Solution {
    int[] coins;
    public int change(int amount, int[] coins) {
        this.coins = coins;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve(dp, 0, amount);
    }

    private int solve(int[][] dp, int index, int amount) {
        if (index >= coins.length) return 0;
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        if (dp[index][amount] != -1) return dp[index][amount];
        dp[index][amount] = solve(dp, index + 1, amount) + solve(dp, index, amount - coins[index]);
        return dp[index][amount];
    }
}