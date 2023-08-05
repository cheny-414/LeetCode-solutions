class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] counts = new int[n];
        int globalLIS = 0;
        int globalCount = 0;

        for (int i = n - 1; i >= 0; i--) {
            length[i] = 1;
            counts[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        counts[i] = counts[j];
                    } else if (length[j] + 1 == length[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
            if (length[i] > globalLIS) {
                globalLIS = length[i];
                globalCount = counts[i];
            } else if (length[i] == globalLIS) {
                globalCount += counts[i];
            }

        }
        return globalCount;
    }
}