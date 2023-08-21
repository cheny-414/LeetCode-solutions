class Solution {
    int[] nums;
    public int[] sortArray(int[] nums) {
        this.nums = nums;
        mergeSort(0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int left, int right) {
        if (right - left <= 0) return;
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int p1 = left, p2 = mid + 1, p = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] < nums[p2]) {
                temp[p] = nums[p1];
                p1++;
            } else {
                temp[p] = nums[p2];
                p2++;
            }
            p++;
        }
        while (p1 <= mid) {
            temp[p] = nums[p1];
            p++;
            p1++;
        }
        while (p2 <= right) {
            temp[p] = nums[p2];
            p++;
            p2++;
        }

        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }
}