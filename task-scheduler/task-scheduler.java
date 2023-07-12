class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1 );
        }

        for (char key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }

        int n_max_freq_chars = 0;
        for (char key : map.keySet()) {
            if (map.get(key) == max) n_max_freq_chars++;
        }

        return Math.max(tasks.length, (max - 1) * (n + 1) + n_max_freq_chars);
    }
}