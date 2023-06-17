class Solution {
    public String breakPalindrome(String palindrome) {
        int length = palindrome.length();
        if (length <= 1) return "";
        int mid = -1;
        if (length % 2 == 1) mid = (length / 2);
        for (int i = 0; i < length; i++) {
            if (palindrome.charAt(i) - 'a' > 0 && (mid == -1 || (mid != -1 && i != mid))) {
                String newString = palindrome.substring(0, i) + "a";
                if (i < length - 1) {
                    newString += palindrome.substring(i+1);
                }
                return newString;
            }
        }
        return palindrome.substring(0, length - 1) + 'b';
    }
}