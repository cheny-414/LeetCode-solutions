class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        UnionFind uf = new UnionFind(n);
        int components = n;
        for (int[] connection : connections) {
            if (uf.union(connection[0], connection[1])) components--;
        }
        return components - 1;
    }

}

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public boolean union(int a, int b) {
        int aParent = find(a), bParent = find(b);
        if (aParent == bParent) return false;
        if (rank[aParent] < rank[bParent]) {
            parent[aParent] = bParent;
            rank[bParent] += rank[aParent];
        } else {
            parent[bParent] = aParent;
            rank[aParent] += rank[bParent];
        }
        return true;
    }
}