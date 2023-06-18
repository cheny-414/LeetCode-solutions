class Solution {
    int[] initial = new int[]{0, 1, 1};
    HashMap<Integer, Integer> map = new HashMap<>();
    public int tribonacci(int n) {
        return trib(n);
    }

    private int trib(int n) {
        if (n <= 2) return initial[n];
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int answer = trib(n - 3) + trib(n - 2) + trib(n - 1);
        map.put(n, answer);
        return answer;
    }
}