class Solution {
    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int days = 0;
        for (int i = 0; i < jobs.length; i++) {
            days = Math.max(days, (int)Math.ceil((double)jobs[i] / workers[i]));
        }
        return days;
    }
}