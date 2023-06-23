class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] answer = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> {
            if (Integer.bitCount(a) == Integer.bitCount(b)) {
                return a - b;
            } else {
                return Integer.bitCount(a) - Integer.bitCount(b);
            }
        });
        for (int num : arr) {
            pq.add(num);
        }

        for (int i = 0; i < n; i++) {
            answer[i] = pq.poll();
        }
        return answer;
    }
}