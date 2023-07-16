class Solution {
    public int singleNumber(int[] nums) {
        int loner = 0;
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            for (int num : nums) {
                bitSum += (num >> i) & 1;
            }
            int lonerBit = bitSum % 3;
            loner = loner | (lonerBit << i);
        }
        return loner;
    }
}