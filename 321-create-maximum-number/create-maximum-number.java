class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] best = new int[k];
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            if (i <= nums1.length && j <= nums2.length) {
                int[] max1 = findMax(nums1, i);
                int[] max2 = findMax(nums2, j);
                int[] result = merge(max1, max2, k);
                boolean isBigger = compare(result, best, 0, 0);
                if (isBigger) {
                    best = result;
                }
            }
        }
        return best;
    }

    private boolean compare(int[] nums1, int[] nums2, int p1, int p2) {
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                return false;
            } else if (nums1[p1] > nums2[p2]) {
                return true;
            } else {
                p1++;
                p2++;
            }
        }
        return p1 < nums1.length;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int p1 = 0, p2 = 0, p = 0;
        while (p < k) {
            res[p++] = compare(nums1, nums2, p1, p2) ? nums1[p1++] : nums2[p2++];
        }
        return res;
    }

    private int[] findMax(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[k];
        int remaining = n - k;
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek() < nums[i] && remaining > 0) {
                stack.pop();
                remaining--;
            }
            stack.push(nums[i]);
        }
        while (remaining > 0) {
            stack.pop();
            remaining--;
        }

        for (int i = k - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}