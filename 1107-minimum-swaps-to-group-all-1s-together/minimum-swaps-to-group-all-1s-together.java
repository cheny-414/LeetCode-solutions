class Solution {
    public int minSwaps(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) count++;
        }

        int countZeros = 0;
        int minZeros = Integer.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            if (data[i] == 0) countZeros++;
        }
        minZeros = Math.min(minZeros, countZeros);
        int left = 0;
        for (int i = count; i < data.length; i++) {
            if (data[i] == 0) {
                countZeros++;
            }
            if (data[left] == 0) {
                countZeros--;
            }
            minZeros = Math.min(minZeros, countZeros);
            left++;
        }
        return minZeros;
    }
}