class Solution {
    public long appealSum(String s) {
        long nums = 0;
        long total = 0;
        long[] prev = new long[26];
        Arrays.fill(prev, -1);

        for (int i = 0; i < s.length(); i++) {
            nums = nums + (i - 0 - prev[s.charAt(i) - 'a']);
            prev[s.charAt(i) - 'a'] = i;
            total += nums;
        }
        return total;
    }
}