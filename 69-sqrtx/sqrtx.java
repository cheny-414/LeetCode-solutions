class Solution {
    public int mySqrt(int x) {
        long lx = x;
        int left = 0;
        int right = x;
        int answer = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if ((long)(mid * mid) <= x) {
                answer = (int)mid;
                left = (int)mid + 1;
            } else {
                right = (int)mid - 1;
            }
        }
        return answer;
    }
}