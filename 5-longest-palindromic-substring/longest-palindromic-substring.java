class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        int globalLeft = -1;
        int globalRight = -1;

        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    globalLeft = left;
                    globalRight = right;
                }
                left--;
                right++;
            }

            left = i; right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    globalLeft = left;
                    globalRight = right;
                }
                left--;
                right++;
            }
        }
        return s.substring(globalLeft, globalRight + 1);
    }
}