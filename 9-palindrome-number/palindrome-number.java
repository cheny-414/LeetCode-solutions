class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) return false; 
        long lx = (long)x;
        long lx2 = lx;
        long reversed = 0;
        while (lx > 0) {
            reversed = reversed * 10 + lx % 10;
            lx /= 10;
        }
        return reversed == lx2;
    }
}