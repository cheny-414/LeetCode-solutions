class Solution {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                stack.offer(s.charAt(i));
            }
            else {
                stack.pollLast();
            }
        }
        
        while (!stack.isEmpty()) {
            ans.append(stack.poll());
        }
        return ans.toString();
    }
}