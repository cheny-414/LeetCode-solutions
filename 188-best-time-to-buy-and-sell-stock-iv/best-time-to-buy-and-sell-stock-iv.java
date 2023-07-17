class Solution {
    public int maxProfit(int k, int[] prices) {
        //max profits achievable if buy with # transactions used
        int[][] hold = new int[prices.length][k + 1];
        int[][] free = new int[prices.length][k + 1];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                free[i][j] = -1000000000;
                hold[i][j] = -1000000000;
            }
        }
        free[0][0] = 0;
        hold[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                free[i][j] = Math.max(free[i - 1][j], hold[i - 1][j] + prices[i]);
                if (j == 0) continue;
                hold[i][j] = Math.max(hold[i - 1][j], free[i - 1][j - 1] - prices[i]);
            }
        }
        int result = 0;
        for (int j = 0; j <= k; j++) {
            result = Math.max(result, free[prices.length - 1][j]);
        }
        return result;
    }
}