class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        for (int[] e : edges) {
            if (!uf.union(e[0], e[1])) return e;
        }
        return new int[]{};
    }
}

class UnionFind {
    int[] parent, size;
    public UnionFind(int n) {
        parent = new int[n]; size = new int[n];
        for (int i = 1; i < n; i++) {
            parent[i] = i; size[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x]) return x;
        return find(parent[x]);
    }

    public boolean union(int u, int v) {
        int parentU = find(u), parentV = find(v);
        if (parentU == parentV) return false;
        if (size[parentU] > size[parentV]) {
            size[parentU] += size[parentV];
            parent[parentV] = parentU;
        } else {
            size[parentV] += size[parentU];
            parent[parentU] = parentV;
        }
        return true;
    }
}