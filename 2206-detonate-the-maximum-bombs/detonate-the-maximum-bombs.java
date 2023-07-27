class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if (i == j) continue;
                if (canDetonate(bombs[i], bombs[j])) {
                    if (!map.containsKey(i)) {
                        map.put(i, new ArrayList<>());
                    }
                    map.get(i).add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < bombs.length; i++) {
            int bombsDetonated = bombsDetonated(i, map, new HashSet<>());
            answer = Math.max(answer, bombsDetonated);
        }
        return answer;
    }

    private int bombsDetonated(int source, Map<Integer, List<Integer>> map, Set<Integer> visited) {
        if (visited.contains(source)) return 0;
        visited.add(source);
        int count = 1;
        for (int neighbor : map.getOrDefault(source, new ArrayList<>())) {
            count += bombsDetonated(neighbor, map, visited);
        }
        return count;
    }

    private boolean canDetonate(int[] source, int[] target) {
        long distance_sqrd = (long)Math.pow(source[0] - target[0], 2) + (long)Math.pow(source[1] - target[1], 2);
        return distance_sqrd <= Math.pow(source[2], 2);
    }
}