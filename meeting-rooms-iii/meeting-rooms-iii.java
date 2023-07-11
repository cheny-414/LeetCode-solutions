class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        int[] count = new int[n];
        var engaged = new PriorityQueue<int[]>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        var unused = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            unused.offer(i);
        }

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];

            while (!engaged.isEmpty() && engaged.peek()[1] <= start) {
                unused.offer(engaged.poll()[0]);
            }

            if (!unused.isEmpty()) {
                int room = unused.poll();
                count[room]++;
                engaged.offer(new int[] {room, end});
            } else {
                int[] earliestAvailableRoom = engaged.poll();
                int room = earliestAvailableRoom[0];
                int roomEndTime = earliestAvailableRoom[1];
                int newEndTime = roomEndTime + end - start;
                count[room]++;
                engaged.offer(new int[] {room, newEndTime});
            }
        }
        int maxRoomId = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoomId])
                maxRoomId = i;
        }
        return maxRoomId;
    }
}