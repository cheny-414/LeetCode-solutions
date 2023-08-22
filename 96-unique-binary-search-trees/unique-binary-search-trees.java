class Solution {
    public int numTrees(int n) {
        return arrangements(1, n);
    }

    private int arrangements(int start, int end) {
        if (start >= end) return 1;
        int answer = 0;
        for (int i = start; i <= end; i++) {
            int left = arrangements(start, i - 1);
            int right = arrangements(i + 1, end);
            answer += left * right;
        }
        return answer;
    }
}