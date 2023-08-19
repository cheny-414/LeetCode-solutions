class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        for (int i = 0; i < edges.length; i++) {
            map.putIfAbsent(edges[i][0], new HashSet<>());
            map.putIfAbsent(edges[i][1], new HashSet<>());
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < n; i++)
            if (map.get(i).size() == 1)
                result.add(i);

        int remaining = n;
        while (remaining > 2) {
            remaining -= result.size();
            List<Integer> newResult = new ArrayList<>();

            for (int node : result) {
                int neighbor = map.get(node).iterator().next();
                map.get(neighbor).remove(node);
                if (map.get(neighbor).size() == 1) {
                    newResult.add(neighbor);
                }
            }
            result = newResult;
        }
        return result;
    }
}