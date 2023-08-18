class Solution {
    public int kthFactor(int n, int k) {
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int sqrtN = (int) Math.sqrt(n);
        for (int x = 1; x <= sqrtN; x++) {
            if (n % x == 0) {
                heap.offer(x);
                if (heap.size() > k) {
                    heap.poll();
                }
                if (x != n / x) {
                    heap.offer(n / x);
                    if (heap.size() > k) {
                        heap.poll();
                    }
                }
            }
        }
        return heap.size() == k ? heap.poll() : -1;
    }
}