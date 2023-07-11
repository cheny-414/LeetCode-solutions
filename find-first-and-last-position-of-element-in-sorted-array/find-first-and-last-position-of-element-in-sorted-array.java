class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int first = -1;
        int last = -1;
        if (nums.length == 0) return new int[] {first, last};
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                first = mid;
                high = mid - 1;
            }
        }
        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                last = mid;
                low = mid + 1;
            }
        }
        return new int[] {first, last};
    }
}