class Solution {
    int[] dp;
    int[][] jobs;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        jobs = new int[startTime.length][3];
        dp = new int[startTime.length];
        Arrays.fill(dp, -1);
        for (int i = 0; i < startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        return solve(0);
    }

    private int solve(int index) {
        //base case
        if (index >= jobs.length) return 0;
        //check cache
        if (dp[index] != -1) {
            return dp[index];
        }
        //recursion
        //take this job:
        int profit1 = jobs[index][2];
        int nextAvailable = binarySearch(index + 1, jobs[index][1]);
        if (nextAvailable != -1) {
            profit1 += solve(nextAvailable);
        }

        //don't take the job
        int profit2 = solve(index + 1);
        return dp[index] = Math.max(profit1, profit2);
    }

    private int binarySearch(int start, int endTime) {
        int left = start;
        int right = jobs.length - 1;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][0] >= endTime) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}