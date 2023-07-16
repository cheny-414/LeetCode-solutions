public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int answer = 0;
        int power = 32;
        while (power != 0) {
            answer = (n & 1) | (answer << 1);
            n >>= 1;
            power--;
        }
        return answer;
    }
}