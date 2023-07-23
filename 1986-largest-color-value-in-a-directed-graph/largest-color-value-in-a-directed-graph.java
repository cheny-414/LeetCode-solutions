class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];

        for (int[] edge : edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<Integer>());
            }
            map.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        int[][] count = new int[n][26];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int answer = 1;
        int nodesSeen = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            nodesSeen++;
            int colorOfNode = colors.charAt(node) - 'a';
            count[node][colorOfNode]++;
            answer = Math.max(answer, count[node][colorOfNode]);

            for (int neighbor : map.getOrDefault(node, new ArrayList<>())) {
                for (int i = 0; i < 26; i++) {
                    count[neighbor][i] = Math.max(count[neighbor][i], count[node][i]);
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if (nodesSeen == n) {
            return answer;
        }
        return -1;
    }
}