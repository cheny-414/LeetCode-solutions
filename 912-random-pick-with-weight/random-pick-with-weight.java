class Solution {
    private int[] prefixSums;
    private int totalSum;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];

        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }

    public int pickIndex() {
        double target = this.totalSum * Math.random();

        // run a binary search to find the target zone
        int low = 0, high = this.prefixSums.length - 1;
        int answer = -1;
        while (low <= high) {
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if (this.prefixSums[mid] >= target) {
                answer = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return answer;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */