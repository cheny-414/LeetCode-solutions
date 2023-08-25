class Solution {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] - nums[0] - mid < k) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[0] + k + answer;
    }
}