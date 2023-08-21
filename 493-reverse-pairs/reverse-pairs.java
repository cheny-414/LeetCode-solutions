class Solution {
    int[] nums;
    public int reversePairs(int[] nums) {
        this.nums = nums;
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(left, mid) + mergeSort(mid + 1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) {
                //count++;
                j++;
            }
            count += j - mid - 1;
        }
        Arrays.sort(nums, left, right + 1);
        return count;
    }
}