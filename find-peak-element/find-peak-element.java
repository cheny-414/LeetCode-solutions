public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == nums.length - 1 || nums[mid] > nums[mid + 1])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}