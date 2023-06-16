class Solution {
    public boolean winnerOfGame(String colors) {
        if (colors.length() <= 2) return false;
        int aScore = 0, bScore = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A') {
                    aScore++;
                } else {
                    bScore++;
                }
            }
        }
        return aScore > bScore;
    }
}