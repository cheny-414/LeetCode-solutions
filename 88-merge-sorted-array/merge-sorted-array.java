class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1P = m - 1;
        int nums2P = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (nums2P < 0) break;
            if (nums1P >= 0 && nums1[nums1P] > nums2[nums2P]) {
                nums1[i] = nums1[nums1P];
                nums1P--;
            } else {
                nums1[i] = nums2[nums2P];
                nums2P--;
            }
        }
    }
}