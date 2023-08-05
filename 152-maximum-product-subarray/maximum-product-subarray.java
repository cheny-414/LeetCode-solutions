class Solution {
    public int maxProduct(int[] nums) {
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = max_so_far;
            max_so_far = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(temp_max * curr, min_so_far * curr));

            result = Math.max(max_so_far, result);
        }
        return result;
    }
}