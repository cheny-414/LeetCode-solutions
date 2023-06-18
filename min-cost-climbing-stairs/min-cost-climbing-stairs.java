class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int minimumCost[] = new int[cost.length + 1];

        for (int i = 2; i < minimumCost.length; i++) {
            int costIfOneStep = minimumCost[i - 1] + cost[i - 1];
            int costIfTwoSteps = minimumCost[i - 2] + cost[i - 2];
            minimumCost[i] = Math.min(costIfOneStep, costIfTwoSteps);
        }
        return minimumCost[minimumCost.length - 1];
    }
}