class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];
            if (!uf.union(A, B)) return false;
        }
        return true;
    }
}

class UnionFind {
    int[] parents;
    int[] sizes;

    public UnionFind(int n) {
        parents = new int[n];
        sizes = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public boolean union(int a, int b) {
        int parent_a = find(a);
        int parent_b = find(b);
        if (parent_a == parent_b) {
            return false;
        }
        if (sizes[parent_a] > sizes[parent_b]) {
            parents[parent_b] = parent_a;
            sizes[parent_a] += sizes[parent_b] + 1;
        } else {
            parents[parent_a] = parent_b;
            sizes[parent_b] += sizes[parent_a] + 1;
        }
        return true;
    }
}