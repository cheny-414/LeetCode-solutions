class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
        }

        int count2 = 0;
        for (int i = 0; i < nums.length && count2 < nums.length - count; i++) {
            if (nums[i] != 0) {
                nums[count2] = nums[i];
                count2++;
            }
        }

        for (int i = count2; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}