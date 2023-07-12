class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        int nodesVisited = 0;

        //build adj list, indegree list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
            indegrees[prereq[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[nodesVisited] = node;
            nodesVisited++;
            for (int neighbor : adj.get(node)) {
                indegrees[neighbor]--;
                if (indegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (nodesVisited == numCourses) {
            return result;
        }

        return new int[] {};
    }
}