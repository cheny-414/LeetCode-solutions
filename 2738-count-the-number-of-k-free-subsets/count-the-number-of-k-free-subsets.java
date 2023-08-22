class Solution {
    public long countTheNumOfKFreeSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> m = new HashMap<>();

        for (int x: nums) {
            int curr = m.getOrDefault(x - k, 0);
            m.remove(x - k);
            m.put(x, curr + 1);
        }

        long res = 1L;
        for (int x: m.values()) res *= fib(x + 2);

        return res;
    }

    public static long fib(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        double f = (Math.pow(phi, n)) / Math.sqrt(5);
        return (long) Math.round(f);
    }
}