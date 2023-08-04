class Solution {
    int[] arr1;
    int[] arr2;
    Map<Pair<Integer, Integer>, Integer> dp = new HashMap<>();
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        this.arr1 = arr1;
        this.arr2 = arr2;
        int answer = solve(0, -1);
        return answer != 1e9 ? answer : -1;
    }

    private int solve(int index, int prev) {
        if (index == arr1.length) return 0;
        if (dp.containsKey(new Pair<>(index, prev))) {
            return dp.get(new Pair<>(index, prev));
        }
        int cost = (int)1e9;
        if (arr1[index] > prev) {
            cost = solve(index + 1, arr1[index]);
        }
        int replacement = binarysearch(prev);
        if (replacement != -1) {
            cost = Math.min(cost, 1 + solve(index + 1, arr2[replacement]));
        }
        dp.put(new Pair<>(index, prev), cost);
        return cost;
    }

    private int binarysearch(int target) {
        int left = 0;
        int right = arr2.length - 1;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr2[mid] > target) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}