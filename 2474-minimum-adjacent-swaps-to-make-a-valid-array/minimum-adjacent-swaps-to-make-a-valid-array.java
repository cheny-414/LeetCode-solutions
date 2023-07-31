class Solution {
    public int minimumSwaps(int[] nums) {
        int minLeft = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
        int maxRight = Integer.MIN_VALUE,max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minLeft = i;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
                maxRight = i;
            }
        }

        if (minLeft <= maxRight) {
            return minLeft + (nums.length - 1 - maxRight);
        } else {
            return minLeft + (nums.length - 1 - maxRight) - 1;
        }
    }
}