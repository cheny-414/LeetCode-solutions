class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        int steps = 1;
        Queue<String> q = new ArrayDeque<>();
        HashSet<String> seen = new HashSet<>();
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        q.add(beginWord);
        seen.add(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                String curr = q.poll();
                if (curr.equals(endWord)) {
                    return steps;
                }
                for (int i = 0; i < curr.length(); i++) {
                    for (int j = 0; j < 26; j++) {
                        String next = curr.substring(0, i) + (char) ('a' + j) + curr.substring(i + 1);
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
}