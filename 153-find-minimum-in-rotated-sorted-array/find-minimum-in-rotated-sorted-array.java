class Solution {
    public int findMin(int[] nums) {
        int numAtLastIndex = nums[nums.length - 1];
        int left = 0;
        int right = nums.length - 1;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= numAtLastIndex) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[answer];
    }
}