class Solution {
    private List<String> wordDict;
    private int[] dp;
    private String s;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        this.s = s;
        dp = new int[s.length()];

        return dp(s.length() - 1);
    }

    private boolean dp(int index) {
        if (index < 0) return true;
        if (dp[index] != 0) return dp[index] == 1;
        for (String word : wordDict) {
            if (index - word.length() + 1 >= 0 && s.substring(index - word.length() + 1, index + 1).equals(word) && dp(index - word.length())) {
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = -1;
        return false;
    }
}