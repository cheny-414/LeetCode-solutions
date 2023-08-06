class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxSize = 0;

        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1];
            while (!pq.isEmpty() && pq.peek() <= startTime) {
                pq.poll();
            }
            pq.offer(endTime);
            maxSize = Math.max(pq.size(), maxSize);
        }
        return maxSize;
    }
}