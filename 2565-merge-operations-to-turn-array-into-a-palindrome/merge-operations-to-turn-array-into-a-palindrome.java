class Solution {
    public int minimumOperations(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int steps = 0;
        while (left < right) {
            if (nums[left] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] < nums[right]) {
                int temp = nums[left];
                left++;
                nums[left] += temp;
                steps++;
            } else {
                int temp = nums[right];
                right--;
                nums[right] += temp;
                steps++;
            }
        }
        return steps;
    }
}