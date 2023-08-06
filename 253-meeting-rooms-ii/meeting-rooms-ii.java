class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {
            int startTime = interval[0];
            int endTime = interval[1];
            if (!pq.isEmpty() && pq.peek() <= startTime) {
                pq.poll();
            }
            pq.offer(endTime);
        }
        return pq.size();
    }
}