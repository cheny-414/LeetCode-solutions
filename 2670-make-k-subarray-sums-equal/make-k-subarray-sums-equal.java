public class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        int box_cnt = gcd(n, k);

        List<Long>[] container = new ArrayList[box_cnt];
        for (int i = 0; i < box_cnt; i++) {
            container[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            container[i % box_cnt].add((long) arr[i]);
        }

        long ans = 0;
        for (List<Long> items : container) {
            Collections.sort(items);
            int item_size = items.size();
            long median;
            if (item_size % 2 == 1)
                median = items.get(item_size / 2);
            else
                median = (items.get((item_size / 2) - 1) + items.get(item_size / 2)) / 2;

            for (long ele : items) {
                ans += Math.abs(median - ele);
            }
        }

        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}