class Solution {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.offer(s.charAt(i));
            }
            else {
                List<Character> decodedString = new ArrayList<>();
                while (!stack.isEmpty() && stack.peekLast() != '[') {
                    decodedString.add(stack.pollLast());
                }
                stack.pollLast();
                int k = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peekLast())) {
                    k = (stack.pollLast() - '0') * base + k;
                    base *= 10;
                }

                while (k != 0) {
                    for (int j = decodedString.size() - 1; j >= 0; j--) {
                        stack.offer(decodedString.get(j));
                    }
                    k--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            res.append(stack.poll());
        }
        return res.toString();
    }
}