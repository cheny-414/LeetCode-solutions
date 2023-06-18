class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        List<Character> open = new ArrayList<Character>(Arrays.asList('(', '{', '['));

        for (char c : s.toCharArray()) {
            if (open.contains(c)) {
                stack.push(c);
            } else {
                if (c == ')') {
                    if (stack.isEmpty()) return false;
                    if (stack.peek() == '(') stack.pop();
                    else return false;
                }
                else if (c == '}') {
                    if (stack.isEmpty()) return false;
                    if (stack.peek() == '{') stack.pop();
                    else return false;
                }
                else if (c == ']') {
                    if (stack.isEmpty()) return false;
                    if (stack.peek() == '[') stack.pop();
                    else return false;
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
}