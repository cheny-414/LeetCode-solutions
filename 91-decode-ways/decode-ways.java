class Solution {
    String s;
    int[] dp;
    public int numDecodings(String s) {
        this.s = s;
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return solve(0);
    }

    private int solve(int index) {
        //base case
        if (index > s.length()) {
            return 0;
        }
        if (index == s.length()) {
            return 1;
        }
        if (index == s.length() - 1) {
            return s.charAt(index) == '0' ? 0 : 1;
        } 

        if (dp[index] != -1) return dp[index];

        int waysAfter2 = 0;
        int waysAfter1 = 0;
        //recursive
        //take 2 letters:
        if (Integer.valueOf(s.substring(index, index + 2)) >= 10 && Integer.valueOf(s.substring(index, index + 2)) <= 26) {
            waysAfter2 = solve(index + 2);
        }

        //take 1 letter
        if (s.charAt(index) != '0') {
            waysAfter1 = solve(index + 1);
        }
        dp[index] = waysAfter1 + waysAfter2;
        return dp[index];
    }
}