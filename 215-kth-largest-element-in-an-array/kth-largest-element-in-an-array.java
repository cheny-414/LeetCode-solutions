class Solution {
    int n;
    int k;
    public int findKthLargest(int[] nums, int k) {
        this.n = nums.length;
        this.k = k;
        return quickSelect(0, n - 1, nums);
    }

    private int quickSelect(int left, int right, int[] nums) {
        int p = left;
        int pivotValue = nums[right];
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivotValue) {
                swap(i, p, nums);
                p++;
            }
        }
        swap(p, right, nums);

        if (p == n - k) {
            return nums[p];
        }
        else if (p < n - k) return quickSelect(p + 1, right, nums);
        else return quickSelect(left, p - 1, nums);
    }

    private void swap(int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}