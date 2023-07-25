class Solution {
    public int[] closestNode(int n, int[][] edges, int[][] query) {
        //build graph first
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] result = new int[query.length];
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            if (!map.containsKey(parent)) {
                map.put(parent, new ArrayList<>());
            }
            if (!map.containsKey(child)) {
                map.put(child, new ArrayList<>());
            }
            map.get(parent).add(child);
            map.get(child).add(parent);
        }

        //run DFS to determine path from A to B
        for (int i = 0; i < query.length; i++) {
            int[] the_query = query[i];
            int start = the_query[0], end = the_query[1], target = the_query[2];
            Set<Integer> path = new HashSet<>();
            dfs(start, end, map, path);
            int minNode = bfs(target, map, path);
            result[i] = minNode;
        }
        return result;
    }

    private boolean dfs(int origin, int dest, Map<Integer, List<Integer>> map, Set<Integer> path) {
        if (path.contains(origin)) return false;
        path.add(origin);
        if (origin == dest) {
            return true;
        }
        for (int neighbor : map.get(origin)) {
            if (dfs(neighbor, dest, map, path)) return true;
        }
        path.remove(origin);
        return false;
    }

    private int bfs(int dest, Map<Integer, List<Integer>> map, Set<Integer> path) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(dest);
        visited.add(dest);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (path.contains(node)) {
                return node;
            }
            for (int neighbor : map.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                }
            }
        }
        return -1;
    }
}