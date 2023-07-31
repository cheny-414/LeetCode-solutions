class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        int[][] sum = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = mat[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = mat[i][j] == 0 ? 0 : dp[i - 1][j] + 1;
            }
        }

        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < n; j++) {
                while (!stack.isEmpty() && dp[i][stack.peek()] >= dp[i][j]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    int preIndex = stack.peek();
                    sum[i][j] = sum[i][preIndex] + dp[i][j] * (j - preIndex);
                } else {
                    sum[i][j] = dp[i][j] * (j + 1);
                }
                stack.push(j);
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += sum[i][j];
            }
        }
        return result;
    }
}