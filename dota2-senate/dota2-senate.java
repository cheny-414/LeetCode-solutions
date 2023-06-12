class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Character> queue = new ArrayDeque<>();
        Deque<Character> temp = new ArrayDeque<>();

        for (int i = 0; i < senate.length(); i++) {
            queue.offer(senate.charAt(i));
        }

        while (!queue.isEmpty()) {
            char current = queue.poll();
            if (temp.isEmpty() || current == temp.peek()) {
                temp.offer(current);
            }
            else {
                queue.offer(temp.poll());
            }
        }

        return temp.peek() == 'R' ? "Radiant" : "Dire";
    }
}