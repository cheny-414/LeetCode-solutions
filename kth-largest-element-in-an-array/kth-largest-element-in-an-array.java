class Solution {
    int k;
    int[] nums;
    public int findKthLargest(int[] nums, int k) {
        this.k = nums.length - k;
        this.nums = nums.clone();
        return quickSelect(0, nums.length - 1);
    }

    private int quickSelect(int l, int r) {
        int pivot = this.nums[r];
        int p = l;

        for (int i = l; i < r; i++) {
            if (this.nums[i] <= pivot) {
                swap(i, p);
                p++;
            }
        }

        swap(p, r);

        if (p > this.k) {
            return quickSelect(l, p - 1);
        } else if (p < k) {
            return quickSelect(p + 1, r);
        } else {
            return this.nums[p];
        }
    }
    private void swap(int a, int b) {
        int temp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = temp;
    }
}