class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int curr = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curr) {
                //uniques.add(nums[i]);
                curr = nums[i];
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}