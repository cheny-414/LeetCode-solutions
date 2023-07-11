class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWait = 0d;
        int startTime = 0;
        int arrivalTime;
        int prepTime;

        for (int[] customer : customers) {
            arrivalTime = customer[0];
            prepTime = customer[1];
            startTime = Math.max(startTime, arrivalTime);
            double customerWait = (startTime + prepTime) - arrivalTime;
            totalWait += customerWait;
            startTime += prepTime;
        }
        return totalWait / customers.length;
    }
}