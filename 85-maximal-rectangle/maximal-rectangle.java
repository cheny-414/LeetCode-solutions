class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            dp[0][i] = (int)matrix[0][i] - '0';
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] == '0' ? 0 : dp[i - 1][j] + 1;
            }
        }

        for (int i = 0; i < m; i++) {
            Stack<Pair<Integer, Integer>> stack = new Stack<>(); //height, index pair
            for (int j = 0; j < n; j++) {
                int start = j;
                while (!stack.isEmpty() && stack.peek().getKey() >= dp[i][j]) {
                    Pair<Integer, Integer> popped = stack.pop();
                    int height = popped.getKey();
                    int index = popped.getValue();
                    maxArea = Math.max(maxArea, height * (j - index));
                    start = index;
                }
                stack.push(new Pair<>(dp[i][j], start));
            }

            while (!stack.isEmpty()) {
                Pair<Integer, Integer> popped = stack.pop();
                int height = popped.getKey();
                int index = popped.getValue();
                maxArea = Math.max(maxArea, height * (n - index));
            }
        }
        return maxArea;
    }
}