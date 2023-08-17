class Solution {

    //jump to an equal or larger num if every num is smaller in between
    //jump to a smaller number if every num is greater or equal in between
    //4 7 2 4 8 6 9
    //i Y Y N N N N
    //i Y N N N N N
    //i N Y N N N N

    //4 5 6 7 8 9
    //i Y N N N N

    //4 3 2 1 4 5 2 9
    //i Y N N N N N N 
    //i N N N N N N N
    //i N N N Y N N N
    public long minCost(int[] nums, int[] costs) {
        Stack<Integer> nextGE = new Stack<>();
        Stack<Integer> nextLT = new Stack<>();
        long[] dp = new long[nums.length];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!nextGE.isEmpty() && nums[i] >= nums[nextGE.peek()]) {
                dp[i] = Math.min(dp[i], dp[nextGE.pop()] + costs[i]);
            }
            while (!nextLT.isEmpty() && nums[i] < nums[nextLT.peek()]) {
                dp[i] = Math.min(dp[i], dp[nextLT.pop()] + costs[i]);
            }
            nextGE.push(i);
            nextLT.push(i);
        }
        return dp[nums.length - 1];
    }
}