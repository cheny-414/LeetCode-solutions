class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = n;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) {
                components--;
            }
        }

        return components;
    }
}

class UnionFind {
    int[] parent;
    int[] size;

    public UnionFind(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public boolean union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a == root_b) return false;
        if (size[root_a] > size[root_b]) {
            parent[root_b] = root_a;
            size[root_a] += size[root_b] + 1;
        } else {
            parent[root_a] = root_b;
            size[root_b] += size[root_a] + 1;
        }
        return true;
    }
}