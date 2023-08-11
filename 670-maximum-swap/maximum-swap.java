class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] largestToRight = new int[digits.length];
        int maxDigit = digits[digits.length - 1] - '0';
        int maxIndex = digits.length - 1;
        largestToRight[digits.length - 1] = -1;
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] - '0' > maxDigit) {
                maxDigit = digits[i] - '0';
                maxIndex = i;
                largestToRight[i] = -1;
            } else if (digits[i] - '0' == maxDigit) {
                largestToRight[i] = -1;
            } else {
                largestToRight[i] = maxIndex;
            }
        }

        for (int i = 0; i < digits.length; i++) {
            if (largestToRight[i] != -1) {
                char temp = digits[i];
                digits[i] = digits[largestToRight[i]];
                digits[largestToRight[i]] = temp;
                break;
            }
        }
        return Integer.valueOf(String.valueOf(digits));
    }
}