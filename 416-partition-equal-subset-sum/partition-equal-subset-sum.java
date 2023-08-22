class Solution {
    Boolean[][] dp;  // (index, diff) -> can partition
    int[] nums;
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        this.nums = nums;
        this.dp = new Boolean[nums.length + 1][totalSum];
        return canDo(0, 0);
    }

    private boolean canDo(int start, int diff) {
        //base case
        if (start == nums.length - 1) {
            return nums[start] == diff || nums[start] == -diff;
        }
        //check dp
        if (dp[start][diff] != null) return dp[start][diff];

        boolean canDo = false;
        //recursion
        //put nums[i] in sum1:
        int diff1 = Math.abs(diff + nums[start]);
        int diff2 = Math.abs(diff - nums[start]);
        if (canDo(start + 1, diff1) || canDo(start + 1, diff2)) {
            canDo = true;
        }
        dp[start][diff] = canDo;
        return canDo;
    }
}