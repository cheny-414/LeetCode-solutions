class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> Double.compare(distance(b), distance(a)));
        for (int[] point : points) {
            q.offer(point);
            if (q.size() > k) {
                q.poll();
            }
        }
        int[][] answer = new int[q.size()][2];
        int i = 0;
        while (!q.isEmpty()) {
            int[] popped = q.poll();
            answer[i][0] = popped[0];
            answer[i][1] = popped[1];
            i++;
        }
        return answer;
    }

    private double distance(int[] point) {
        return Math.sqrt(Math.pow(point[0] - 0, 2) + Math.pow(point[1] - 0, 2));
    }
}