class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        List<Integer> empty = new ArrayList<>();
        res.add(empty);
        dfs(empty, 0);
        return res;
    }

    private void dfs(List<Integer> curr, int start) {
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            List<Integer> next = new ArrayList<>(curr);
            next.add(nums[i]);
            res.add(next);
            dfs(next, i + 1);
        }
    }
}