class Solution {
    List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    public String reverseVowels(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] reversed = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (!vowels.contains(s.charAt(i))) {
                reversed[i] = s.charAt(i);
            }
            else {
                stack.offer(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            for (int i = 0; i < s.length(); i++) {
                if (reversed[i] == 0) {
                    reversed[i] = stack.pollLast();
                }
            }
        }
        return String.valueOf(reversed);
    }
}