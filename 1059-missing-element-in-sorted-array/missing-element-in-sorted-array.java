class Solution {
    public int missingElement(int[] nums, int k) {
        int missing = nums[0] + k;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= missing) {
                missing ++;
            }
        }
        return missing;
    }
}