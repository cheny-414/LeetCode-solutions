class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = candidates;
        PriorityQueue<Integer> headWorkers = new PriorityQueue<>();
        PriorityQueue<Integer> tailWorkers = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            headWorkers.add(costs[i]);
        }
        for (int i = Math.max(n, costs.length - n); i < costs.length; i++) {
            tailWorkers.add(costs[i]);
        }

        long answer = 0;
        int nextHead = n;
        int nextTail = costs.length - n - 1;

        for (int i = 0; i < k; i++) {
            if (!headWorkers.isEmpty() && (tailWorkers.isEmpty() || headWorkers.peek() <= tailWorkers.peek())) {
                answer += headWorkers.poll();

                if (nextHead <= nextTail) {
                    headWorkers.add(costs[nextHead]);
                    nextHead++;
                }
            }
            else {
                answer += tailWorkers.poll();

                if (nextHead <= nextTail) {
                    tailWorkers.add(costs[nextTail]);
                    nextTail--;
                }
            }
        }

        return answer;
    }
}