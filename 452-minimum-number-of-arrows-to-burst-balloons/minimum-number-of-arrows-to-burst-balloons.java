class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 1;
        int end = points[0][1];
        for(int[] point : points) {
            if(point[0] <= end) {
                end = Math.min(end, point[1]);
            } else {
                end = point[1];
                ans++;
            }
        }
        return ans;
    }
}