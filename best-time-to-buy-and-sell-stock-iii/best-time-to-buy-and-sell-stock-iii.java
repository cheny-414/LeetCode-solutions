class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int leftMin = prices[0];
        int rightMax = prices[length - 1];
        int[] leftProfits = new int[length];
        int[] rightProfits = new int[length + 1];

        for (int i = 1; i < length; i++) {
            leftMin = Math.min(leftMin, prices[i]);
            leftProfits[i] = Math.max(leftProfits[i - 1], prices[i] - leftMin);

            int r = length - i - 1;
            rightMax = Math.max(rightMax, prices[r]);
            rightProfits[r] = Math.max(rightProfits[r + 1], rightMax - prices[r]);
        }

        int maxProfit = 0;
        for (int i = 0; i < length; i++) {
            maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i + 1]);
        }
        return maxProfit;
    }
}