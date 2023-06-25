class Solution {
    public int removeDuplicates(int[] nums) {
        int curr = nums[0];
        int seen = 1;
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curr) {
                nums[p] = nums[i];
                p++;
                seen = 1;
                curr = nums[i];
            } else if (seen < 2) {
                nums[p] = nums[i];
                p++;
                seen++;
            }
        }
        return p;
    }
}