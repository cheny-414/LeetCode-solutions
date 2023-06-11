class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int j = 0; j < k; j++) {
            sum += nums[j];
        }
        int max = sum;

        for (int i = 1; i < nums.length - k + 1; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            max = Math.max(max, sum);
        }
        return Double.valueOf(max) / k;
    }
}