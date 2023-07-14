class Solution {
    int[] dp;
    public int maxJumps(int[] arr, int d) {
        dp = new int[arr.length];
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = Math.max(result, maxVisited(i, arr, d));
        }
        return result;
    }

    private int maxVisited(int index, int[] arr, int d) {
        if (dp[index] != 0) return dp[index];
        int maxVisited = 1;
        for (int j = 1; j <= d; j++) {
            if (index + j >= 0 && index + j < arr.length) {
                if (arr[index + j] >= arr[index]) break;
                maxVisited = Math.max(maxVisited, 1 + maxVisited(index + j, arr, d));
            }
        }

        for (int j = -1; j >= -d; j--) {
            if (index + j >= 0 && index + j < arr.length) {
                if (arr[index + j] >= arr[index]) break;
                maxVisited = Math.max(maxVisited, 1 + maxVisited(index + j, arr, d));
            }
        }
        dp[index] = maxVisited;
        return maxVisited;
    }
}