class Solution {
    public int maxSubArray(int[] nums) {
        int bestSum = nums[0];
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            bestSum = Math.max(currSum, bestSum);
        }
        return bestSum;
    }
}