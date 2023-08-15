class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1000000007;
        long answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int popped = stack.pop();
                int leftBound = stack.isEmpty() ? -1 : stack.peek();
                int rightBound = i;
                long count = (popped - leftBound) * (rightBound - popped) % MOD;
                answer += (count * arr[popped]) % MOD;
                answer %= MOD;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int popped = stack.pop();
            int leftBound = stack.isEmpty() ? -1 : stack.peek();
            int rightBound = arr.length;
            long count = (popped - leftBound) * (rightBound - popped) % MOD;
            answer += (count * arr[popped]) % MOD;
            answer %= MOD;
        }
        return (int) answer;
    }
}