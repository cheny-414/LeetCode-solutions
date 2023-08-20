class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> empty = new ArrayList<>();
        used = new boolean[nums.length];
        //Arrays.sort(nums);
        this.nums = nums;
        dfs(empty);
        return res;
    }

    private void dfs(List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            //if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) continue;
            used[i] = true;
            curr.add(nums[i]);
            dfs(curr);
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}