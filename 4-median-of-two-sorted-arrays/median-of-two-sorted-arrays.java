class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = m;
        while (left <= right) {
            int partitionIndexOfM = left + (right - left) / 2;
            int partitionIndexOfN = (m + n) / 2 - partitionIndexOfM;

            int maxOnLeftM = partitionIndexOfM == 0 ? Integer.MIN_VALUE : nums1[partitionIndexOfM - 1];
            int maxOnLeftN = partitionIndexOfN == 0 ? Integer.MIN_VALUE : nums2[partitionIndexOfN - 1];
            int minOnRightM = partitionIndexOfM == m ? Integer.MAX_VALUE : nums1[partitionIndexOfM];
            int minOnRightN = partitionIndexOfN == n ? Integer.MAX_VALUE : nums2[partitionIndexOfN];

            if (maxOnLeftM <= minOnRightN && maxOnLeftN <= minOnRightM) {
                if ((m + n) % 2 == 0) {
                    int maxOnLeft = Math.max(maxOnLeftM, maxOnLeftN);
                    int minOnRight = Math.min(minOnRightM, minOnRightN);
                    return (double)(maxOnLeft + minOnRight) / 2.0;
                } else {
                    return Math.min(minOnRightM, minOnRightN);
                }
            } else if (maxOnLeftM > minOnRightN) {
                right = partitionIndexOfM - 1;
            } else {
                left = partitionIndexOfM + 1;
            }
        }
        return -1;
    }
}