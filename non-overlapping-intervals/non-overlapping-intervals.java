class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prevEnd = intervals[0][1];
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}