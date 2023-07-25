class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != ']') {
                stack.push(c);
            } else {
                String decoded = "";
                int count = 0;
                int base = 1;
                while (stack.peek() != '[') {
                    decoded += stack.pop();
                }
                stack.pop();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    count += (stack.pop() - '0') * base;
                    base *= 10;
                }
                for (int j = 0; j < count; j++) {
                    for (int k = decoded.length() - 1; k >= 0; k--) {
                        stack.push(decoded.charAt(k));
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pollLast());
        }
        return result.toString();
    }
}