class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                int[] edge = new int[] {weight, i, j};
                edges.add(edge);
            }
        }
        Collections.sort(edges, (a, b) -> Integer.compare(a[0], b[0]));
        UnionFind uf = new UnionFind(n);
        int answer = 0;
        int edgesUsed = 0;
        for (int i = 0; i < edges.size(); i++) {
            int weight = edges.get(i)[0];
            int node1 = edges.get(i)[1];
            int node2 = edges.get(i)[2];
            if (uf.union(node1, node2)) {
                answer += weight;
                edgesUsed++;
                if (edgesUsed == n - 1) return answer;
            }
        }
        return answer;
    }
}

class UnionFind {
    public int[] group;
    public int[] rank;

    public UnionFind(int size) {
        group = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; ++i) {
            group[i] = i;
        }
    }

    public int find(int node) {
        if (group[node] != node) {
            group[node] = find(group[node]);
        }
        return group[node];
    }

    public boolean union(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);
        
        // node1 and node2 already belong to same group.
        if (group1 == group2) {
            return false;
        }

        if (rank[group1] > rank[group2]) {
            group[group2] = group1;
        } else if (rank[group1] < rank[group2]) {
            group[group1] = group2;
        } else {
            group[group1] = group2;
            rank[group2] += 1;
        }

        return true;
    }
}