class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            int sum = 0;
            int temp = i;
            while (temp != 0) {
                sum++;
                temp &= (temp - 1);
            }
            result[i] = sum;
        }
        return result;
    }
}