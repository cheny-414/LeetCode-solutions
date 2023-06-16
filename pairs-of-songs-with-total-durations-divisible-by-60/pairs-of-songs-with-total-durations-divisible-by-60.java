class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        int pairs = 0;
        for (int song : time) {
            map.put(song % 60, map.getOrDefault(song % 60, 0) + 1);
        }

        pairs += map.getOrDefault(30, 0) * (map.getOrDefault(30, 0) - 1) / 2;
        pairs += (long)map.getOrDefault(0, 0) * (map.getOrDefault(0, 0) - 1) / 2;
        for (int i : map.keySet()) {
            if (i != 30 && i != 0 && !seen.contains(i)) {
                pairs += map.getOrDefault(i, 0) * map.getOrDefault(60-i, 0);
                seen.add(60-i);
            }
        }
        return pairs;
    }
}