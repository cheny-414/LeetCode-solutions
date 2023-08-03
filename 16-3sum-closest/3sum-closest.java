class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = sum - target;
                if (diff == 0) return sum;
                if (Math.abs(diff) < Math.abs(closest)) {
                    closest = diff;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return target + closest;
    }
}