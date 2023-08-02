class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty() && stack.peekLast() == '0') {
            stack.pollLast();
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pollLast());
        }
        String ret = answer.toString();
        return ret.length() == 0 ? "0" : ret;
    }
}