class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>> ans = new ArrayList<>();

        //i, j
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        //sum, i, j
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] {nums1[0] + nums2[0], 0, 0});
        //visited.add(new Pair<Integer, Integer>(0, 0));

        int count = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[1];
            int j = curr[2];
            if (visited.contains(new Pair<>(i, j))) continue;
            visited.add(new Pair<>(i, j));

            ans.add(List.of(nums1[i], nums2[j]));
            count++;
            if (count == k) return ans;

            if (i + 1 < m) {
                pq.offer(new int[] {nums1[i + 1] + nums2[j], i + 1, j});
                //visited.add(new Pair<>(i + 1, j));
            }

            if (j + 1 < n) {
                pq.offer(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
                //visited.add(new Pair<>(i, j + 1));
            }
        }
        return ans;
    }
}