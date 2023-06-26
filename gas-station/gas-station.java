class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) return -1;

        int currGain = 0;
        int ans = 0;
        for (int i = 0; i < gas.length; i++) {
            currGain += gas[i] - cost[i];
            if (currGain < 0) {
                ans = i + 1;
                currGain = 0;
            }
        }
        return ans;
    }
}