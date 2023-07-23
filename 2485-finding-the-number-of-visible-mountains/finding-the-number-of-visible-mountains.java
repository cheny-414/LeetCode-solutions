class Solution {
    public int visibleMountains(int[][] peaks) {
        int answer = 0;
        for (int[] peak : peaks) {
            int height = peak[1];
            int pos = peak[0];
            peak[0] = pos - height;
            peak[1] = pos + height;
        }
        Arrays.sort(peaks, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int maxEnd = Integer.MIN_VALUE;
        for (int i = 0; i < peaks.length; i++) {
            if (peaks[i][1] > maxEnd) {
                maxEnd = peaks[i][1];
                if (i + 1 < peaks.length && peaks[i][0] == peaks[i+1][0] && peaks[i][1] == peaks[i+1][1]) continue;
                answer++;
            }
        }

        return answer;
    }
}