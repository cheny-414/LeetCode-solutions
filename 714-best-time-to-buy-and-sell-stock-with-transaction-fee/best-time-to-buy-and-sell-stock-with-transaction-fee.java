class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length; 
        int free = 0;
        int hold = -prices[0];

        for(int i = 1; i < n; i++) {
            int prevFree = free;
            free = Math.max(free, hold + prices[i] - fee);
            hold = Math.max(hold, prevFree - prices[i]);
        }
        return free;
    }
}