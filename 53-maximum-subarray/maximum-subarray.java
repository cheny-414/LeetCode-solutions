class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int answer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            answer = Math.max(sum, answer);
        }
        return answer;
    }
}