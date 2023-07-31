class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] nearestLeftCandle = new int[n];
        int[] nearestRightCandle = new int[n];
        int[] candleCount = new int[n];
        int[] answer = new int[queries.length];

        int nearest = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                nearest = i;
            }
            nearestLeftCandle[i] = nearest;
        }

        nearest = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                nearest = i;
            }
            nearestRightCandle[i] = nearest;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                count++;
            }
            candleCount[i] = count;
        }

        int index = 0;
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];

            int leftmostCandle = nearestRightCandle[left];
            int rightmostCandle = nearestLeftCandle[right];
            if (leftmostCandle == -1 || rightmostCandle == -1) {
                answer[index++] = 0;
            } else {
                if (rightmostCandle - leftmostCandle < 1) {
                    answer[index++] = 0;
                } else {
                    int everything = rightmostCandle - leftmostCandle + 1;
                    int candlesCount = candleCount[rightmostCandle] - candleCount[leftmostCandle] + 1;
                    int plates = everything - candlesCount;
                    answer[index++] = plates;
                }
            }
        }
        return answer;
    }
}