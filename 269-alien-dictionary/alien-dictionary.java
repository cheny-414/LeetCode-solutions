class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> indegrees = new HashMap<>();
        Queue<Character> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegrees.put(c, 0);
                map.put(c, new ArrayList<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            Pair<Character, Character> edge = getEdge(words[i - 1], words[i]);
            if (edge != null) {
                if (edge.getKey() == '-') return "";
                char from = edge.getKey();
                char to = edge.getValue();
                map.get(from).add(to);
                indegrees.put(to, indegrees.getOrDefault(to, 0) + 1);
            }
        }

        int expectedSize = map.size();

        for (char to : map.keySet()) {
            if (indegrees.getOrDefault(to, 0) == 0) {
                q.add(to);
            }
        }

        while (!q.isEmpty()) {
            char c = q.poll();
            sb.append(c);
            for (char next : map.get(c)) {
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) == 0) {
                    q.add(next);
                }
            }
        }

        if (sb.length() < expectedSize) {
            return "";
        }
        return sb.toString();
    }

    private Pair<Character, Character> getEdge(String word1, String word2) {
        if (word1.length() > word2.length() && word1.startsWith(word2)) {
            return new Pair<>('-', '-');
        }
        for (int i = 0; i < word1.length() && i < word2.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return new Pair<>(word1.charAt(i), word2.charAt(i));
            }
        }
        return null;
    }
}