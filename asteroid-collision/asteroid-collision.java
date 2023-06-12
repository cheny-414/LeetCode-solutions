class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0) {
                stack.offer(asteroids[i]);
            }
            else {
                while(stack.peekLast() != null && stack.peekLast() > 0 && stack.peekLast() < Math.abs(asteroids[i])) {
                    stack.pollLast();
                }

                if (stack.peekLast() == null || stack.peekLast() < 0) {
                    stack.offer(asteroids[i]);
                }
                else if (stack.peekLast() == Math.abs(asteroids[i])) {
                    stack.pollLast();
                }
            }
        }
        int[] answer = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            answer[i++] = stack.poll();
        }
        return answer;
    }
}