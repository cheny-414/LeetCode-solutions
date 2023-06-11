class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        for(; i < Math.min(word1.length(), word2.length()); i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        if (word1.length() < word2.length()) {
            for (; i < word2.length(); i++) {
                result.append(word2.charAt(i));
            }
        } else {
            for (; i < word1.length(); i++) {
                result.append(word1.charAt(i));
            }
        }
        return result.toString();
    }
}