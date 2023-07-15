class Solution {
    public int search(int[] nums, int target) {
        int numAtLastIndex = nums[nums.length - 1];
        int left = 0;
        int right = nums.length - 1;
        int pivotIndex = -1;

        //binary search for pivot
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= numAtLastIndex) {
                pivotIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        //binary search in left of pivot
        left = 0;
        right = pivotIndex - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        //binary search in right of pivot
        left = pivotIndex;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}