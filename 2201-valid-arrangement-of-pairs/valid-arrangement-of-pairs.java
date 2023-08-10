class Solution {
    HashMap<Integer, Stack<Integer>> map = new HashMap<>();
    List<Integer> path;
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, Integer> degree = new HashMap<>();

        for (int[] pair : pairs) {
            map.putIfAbsent(pair[0], new Stack<>());
            map.get(pair[0]).push(pair[1]);
            degree.put(pair[0], degree.getOrDefault(pair[0], 0) - 1);
            degree.put(pair[1], degree.getOrDefault(pair[1], 0) + 1);
        }

        int start = pairs[0][0];
        for (int[] pair : pairs) {
            if (degree.get(pair[0]) == -1) {
                start = pair[0];
                break;
            }
        }

        path = new ArrayList<>();
        dfs(start);
        Collections.reverse(path);

        int[][] result = new int[pairs.length][2];

        for (int i = 1; i < path.size(); i++) {
            result[i - 1][0] = path.get(i - 1);
            result[i - 1][1] = path.get(i);
        }
        return result;
    }

    private void dfs(int node) {
        while (map.containsKey(node) && !map.get(node).isEmpty()) {
            dfs(map.get(node).pop());
        }
        path.add(node);
    }
}