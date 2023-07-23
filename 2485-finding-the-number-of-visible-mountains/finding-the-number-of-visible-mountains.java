class Solution {
    public int visibleMountains(int[][] peaks) {
        int answer = 0;
        for (int[] peak : peaks) {
            int height = peak[1];
            int pos = peak[0];
            peak[0] = pos - height;
            peak[1] = pos + height;
        }
        Arrays.sort(peaks, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int i = 0;
        while(i < peaks.length){
            answer++;
            
            if (i + 1 == peaks.length) return answer;

            int start = peaks[i][0];
            int end = peaks[i][1];
            if(start == peaks[i + 1][0]){
                answer--;
            }
            while(i + 1 != peaks.length && end >= peaks[i + 1][1]){
                    i++;
            }
            i++;
        }

        return answer;
    }
}