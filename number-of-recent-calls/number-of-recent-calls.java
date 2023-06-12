class RecentCounter {
    Deque<Integer> deque;
    public RecentCounter() {
        deque = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        while (!deque.isEmpty()) {
            if (deque.peek() < t - 3000) {
                deque.poll();
            }
            else {
                break;
            }
        }
        deque.offer(t);
        return deque.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */