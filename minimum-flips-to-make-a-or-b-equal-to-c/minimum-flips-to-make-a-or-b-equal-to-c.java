class Solution {
    public int minFlips(int a, int b, int c) {
        int answer = 0;
        int result1 = (a | b) ^ c;
        int result2 = (a & b) & result1;
        return Integer.bitCount(result1) + Integer.bitCount(result2);
    }
}