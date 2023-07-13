class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                int start = i;
                int streak = 0;
                while (i < seats.length && seats[i] == 0) {
                    streak++;
                    i++;
                }
                int distance;
                //calculate max distance in this streak;
                if (start == 0 || i == seats.length) {
                    distance = streak;
                } else {
                    distance = (streak + 1) / 2;
                }
                maxDistance = Math.max(maxDistance, distance);
            }
        }
        return maxDistance;
    }
}