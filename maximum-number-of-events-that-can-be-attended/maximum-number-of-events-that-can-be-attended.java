class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int i = 0, result = 0, n = events.length;

        for (int d = 1; d <= 100000; d++) {
            while (i < n && events[i][0] <= d) {
                pq.offer(events[i][1]);
                i++;
            }
            if (!pq.isEmpty()) {
                pq.poll();
                result++;
            }
            while (!pq.isEmpty() && pq.peek() <= d) {
                pq.poll();
            }
        }
        return result;
    }
}