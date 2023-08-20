class Solution {
  List<List<Integer>> res = new ArrayList<>();
  int[] nums;
  public List<List<Integer>> subsets(int[] nums) {
    List<Integer> empty = new ArrayList<>();
    this.nums = nums;
    res.add(empty);
    dfs(empty, 0);
    return res;
  }
  private void dfs(List<Integer> curr, int start) {
    for (int i = start; i < nums.length; i++) {
      List<Integer> next = new ArrayList<>();
      next.addAll(curr);
      next.add(nums[i]);
      res.add(next);
      dfs(next, i + 1);
    }
  }
}