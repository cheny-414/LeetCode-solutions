class Solution {
    Map<Integer, List<List<Integer>>> map = new HashMap<>();
    int count = 0;

    public int minReorder(int n, int[][] connections) {
        for (int[] connection : connections) {
            map.computeIfAbsent(connection[0], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(connection[1], 1));
            map.computeIfAbsent(connection[1], k -> new ArrayList<List<Integer>>()).add(Arrays.asList(connection[0], 0));
        }
        dfs(0, -1);
        return count;
    }

    private void dfs(int node, int origin) {
        for (List<Integer> adj : map.get(node)) {
            int destination = adj.get(0);
            int direction = adj.get(1);
            if (destination != origin) {
                count += direction;
                dfs(destination, node);
            }
        }
    }
}