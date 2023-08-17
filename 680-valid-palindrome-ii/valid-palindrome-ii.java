class Solution {
    public boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1);
    }

    private boolean helper(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPal(s, left + 1, right) || isPal(s, left, right - 1);
            }
        }
        return true;
    }

    private boolean isPal(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}