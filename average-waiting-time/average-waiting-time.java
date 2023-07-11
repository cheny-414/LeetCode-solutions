class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWait = 0;
        int startTime = 0;
        int arrivalTime;
        int prepTime;

        for (int[] customer : customers) {
            arrivalTime = customer[0];
            prepTime = customer[1];
            startTime = Math.max(startTime, arrivalTime);
            int customerWait = (startTime + prepTime) - arrivalTime;
            totalWait += customerWait;
            startTime += prepTime;
        }
        return (double)totalWait * 1.0 / customers.length;
    }
}