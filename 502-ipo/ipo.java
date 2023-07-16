class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] data = new int[n][2];
        int count = 0;
        int pointer = 0;

        for (int i = 0; i < n; i++) {
            data[i][0] = profits[i];
            data[i][1] = capital[i];
        }

        //Capital ascending, then profits descending
        Arrays.sort(data, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

        //PriorityQueue: Profits descending
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        while (count < k) {
            //enqueue affordable projects
            while (pointer < n && data[pointer][1] <= w) {
                q.add(data[pointer++]);
            }

            //do project
            if (!q.isEmpty()) {
                int[] project = q.poll();
                w += project[0];
                count++;
            } else {
                return w;
            }
        }

        return w;
    }
}