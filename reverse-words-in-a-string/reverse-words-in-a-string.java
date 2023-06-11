class Solution {
    public String reverseWords(String s) {
        String trimmed = s.trim() + " ";
        StringBuilder word = new StringBuilder();
        StringBuilder reversed = new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < trimmed.length(); i++) {
            if (trimmed.charAt(i) != ' ') {
                word.append(trimmed.charAt(i));
            }
            else {
                if (word.length() > 0) {
                    stack.offer(word.toString());
                    word.setLength(0);
                }
            }
        }
        while(!stack.isEmpty()) {
            reversed.append(stack.pollLast() + " ");
        }
        return reversed.toString().trim();
    }
}