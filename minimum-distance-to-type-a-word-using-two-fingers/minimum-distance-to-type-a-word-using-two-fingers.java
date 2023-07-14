class Solution {
    int[][][] dp;
    String word;
    public int minimumDistance(String word) {
        dp = new int[301][27][27];
        this.word = word;
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 27; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 26, 26);
    }

    private int solve(int index, int finger1, int finger2) {
        if (index == word.length()) return 0;
        if (dp[index][finger1][finger2] != -1) return dp[index][finger1][finger2];
        int charPosition = word.charAt(index) - 'A';
        int cost_for_finger1 = getCost(finger1, charPosition);
        int cost_for_finger2 = getCost(finger2, charPosition);
        dp[index][finger1][finger2] = Math.min(cost_for_finger1 + solve(index + 1, charPosition, finger2), 
                                            cost_for_finger2 + solve(index + 1, finger1, charPosition));
        return dp[index][finger1][finger2];
    }

    private int getCost(int from, int to) {
        if (from == 26) return 0;
        return Math.abs(from / 6 - to / 6) + Math.abs(from % 6 - to % 6);
    }
}