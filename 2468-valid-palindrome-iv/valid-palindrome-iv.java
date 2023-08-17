class Solution {
    public boolean makePalindrome(String s) {
        int misMatches = 0;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                misMatches++;
            }
            left++;
            right--;
        }
        return misMatches <= 2;
    }
}