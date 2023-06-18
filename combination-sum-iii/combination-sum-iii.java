class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int max;
    int target;
    public List<List<Integer>> combinationSum3(int k, int n) {
        max = k;
        target = n;
        List<Integer> list = new ArrayList<>();
        backtrack(list, 0);
        return result;
    }

    private void backtrack(List<Integer> list, int sum) {
        if (list.size() == max && sum == target) {
            result.add(list);
            return;
        }
        int num;
        num = list.isEmpty() ? 0 : list.get(list.size() - 1);

        for (int i = num + 1; i <= 9; i++) {
            if (list.size() <= max - 1 && sum + i <= target) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(i);
                backtrack(newList, sum + i);
            }
        }
    }
}