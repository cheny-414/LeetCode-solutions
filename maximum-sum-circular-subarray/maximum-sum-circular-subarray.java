class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0;
        int currMin = 0;
        int maxSum = nums[0];
        int minSum = nums[0];
        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(currMax, maxSum);

            currMin = Math.min(currMin + nums[i], nums[i]);
            minSum = Math.min(currMin, minSum);

            total += nums[i];
        }

        if (maxSum < 0) return maxSum;
        
        return Math.max(maxSum, total - minSum);
    }
}