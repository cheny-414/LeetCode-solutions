class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        for (int i = 1; i < n; i++) {
            if (q.peekFirst() != null && q.peekFirst() < i - k) {
                q.pollFirst();
            }
            dp[i] = nums[i] + dp[q.peekFirst()];
            while (q.peekLast() != null && dp[i] > dp[q.peekLast()]) {
                q.pollLast();
            }
            q.offerLast(i);
        }
        return dp[n - 1];
    }
}