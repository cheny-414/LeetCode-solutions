class Solution {
    Set<Integer> set;
    int last;
    Map<String, Boolean> dp;
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        this.set = new HashSet<>();
        this.dp = new HashMap<>();
        this.last = stones[stones.length - 1];
        for (int stone : stones) {
            set.add(stone);
        }
        return helper(stones[1], 1);
    }

    private boolean helper(int curr, int k) {
        if (curr == last) return true;
        if (curr > last) return false;
        String key = curr + " " + k;
        if (dp.containsKey(key)) return dp.get(key);
        boolean canCross = false;
        if (k - 1 > 0 && set.contains(curr + k - 1) && helper(curr + k - 1, k - 1)) {
            canCross = true;
        }
        if (set.contains(curr + k) && helper(curr + k, k)) {
            canCross = true;
        }
        if (set.contains(curr + k + 1) && helper(curr + k + 1, k + 1)) {
            canCross = true;
        }
        dp.put(key, canCross);
        return canCross;
    }
}