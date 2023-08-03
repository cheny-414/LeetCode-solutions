class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1l);
        long polled = -1l;

        for (int i = 1; i <= n; i++) {
            polled = pq.poll();
            while (!pq.isEmpty() && pq.peek() == polled) pq.poll();

            pq.add(polled * 2);
            pq.add(polled * 3);
            pq.add(polled * 5);
        }
        return (int) polled;
    }
}