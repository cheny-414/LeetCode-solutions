class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        q.add(beginWord);
        int steps = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String popped = q.poll();
                seen.add(popped);
                if (popped.equals(endWord)) return steps;
                for (int i = 0; i < popped.length(); i++) {
                    for (int j = 0; j < 26; j++) {
                        String next = popped.substring(0, i) + (char) ('a' + j) + popped.substring(i + 1);
                        if (!seen.contains(next) && set.contains(next)) {
                            seen.add(next);
                            q.add(next);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    private boolean isAdjacent(String word1, String word2) {
        int mismatches = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                mismatches++;
                if (mismatches > 1) return false;
            }
        }
        return true;
    }
}