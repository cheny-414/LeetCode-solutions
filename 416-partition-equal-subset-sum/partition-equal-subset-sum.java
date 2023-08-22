class Solution {
    Map<Pair<Integer, Integer>, Boolean> dp;  // (index, diff) -> can partition
    int[] nums;
    int targetSum;
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        this.nums = nums;
        this.targetSum = totalSum / 2;
        this.dp = new HashMap<>();
        return canDo(0, 0);
    }

    private boolean canDo(int start, int diff) {
        //base case
        if (start == nums.length - 1) {
            return nums[start] == diff || nums[start] == -diff;
        }
        if (diff > targetSum) return false;
        //check dp
        Pair<Integer, Integer> key = new Pair<>(start, diff);
        if (dp.containsKey(key))return dp.get(key);

        boolean canDo = false;
        //recursion
        //put nums[i] in sum1:
        int diff1 = Math.abs(diff + nums[start]);
        int diff2 = Math.abs(diff - nums[start]);
        if (canDo(start + 1, diff1) || canDo(start + 1, diff2)) {
            canDo = true;
        }
        dp.put(key, canDo);
        return canDo;
    }
}