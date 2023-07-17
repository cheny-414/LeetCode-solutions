class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int answer = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    int above = i == 0 ? 0 : dp[i - 1][j];
                    int aboveAndLeft = (i == 0 || j == 0) ? 0 : dp[i - 1][j - 1];
                    int left = j == 0 ? 0 : dp[i][j - 1];
                    dp[i][j] = Math.min(above, Math.min(aboveAndLeft, left)) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        return answer * answer;
    }
}