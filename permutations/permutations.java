class Solution {
    List<List<Integer>> ans;
    int n;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        n = nums.length;
        backtrack(new ArrayList<Integer>(), nums);
        return ans;
    }

    private void backtrack(List<Integer> list, int[] nums) {
        if (list.size() == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                backtrack(list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}