class Solution {
    int[][][] dp;
    String word;
    public int minimumDistance(String word) {
        this.word = word;
        this.dp = new int[301][27][27]; //index of character to print, finger1 position, finger2 position
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 26, 26);
    }

    //min cost to type starting from index
    private int solve(int index, int finger1, int finger2) {
        if (index >= word.length()) {
            return 0;
        }
        if (dp[index][finger1][finger2] != -1) {
            return dp[index][finger1][finger2];
        }
        int charToPrintPosition = word.charAt(index) - 'A';
        int costForFinger1 = getDistance(finger1, charToPrintPosition);
        int costForFinger2 = getDistance(finger2, charToPrintPosition);
        dp[index][finger1][finger2] = Math.min(costForFinger1 + solve(index + 1, charToPrintPosition, finger2),
                                                costForFinger2 + solve(index + 1, finger1, charToPrintPosition));
        return dp[index][finger1][finger2];
    }

    private int getDistance(int pos1, int pos2) {
        if (pos1 == 26) return 0;
        int row1 = pos1 / 6;
        int col1 = pos1 % 6;
        int row2 = pos2 / 6;
        int col2 = pos2 % 6;
        return Math.abs(row1 - row2) + Math.abs(col1 - col2);
    }
}