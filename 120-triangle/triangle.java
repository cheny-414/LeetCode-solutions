class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return helper(0, 0, triangle, dp);
    }

    private int helper(int level, int index, List<List<Integer>> triangle, int[][] dp) {
        if (level > triangle.size() - 1) return 0;
        int currCost = triangle.get(level).get(index);
        if (level == triangle.size()) {
            return currCost;
        }
        if (dp[level][index] != Integer.MIN_VALUE) return dp[level][index];
        dp[level][index] = currCost + Math.min(helper(level + 1, index, triangle, dp), helper(level + 1, index + 1, triangle, dp));
        return dp[level][index];
    }
}