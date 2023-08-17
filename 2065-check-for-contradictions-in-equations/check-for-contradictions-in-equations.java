class Solution {
    public boolean checkContradictions(List<List<String>> equations, double[] values) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            map.putIfAbsent(a, map.size());
            map.putIfAbsent(b, map.size());
        }
        UnionFind uf = new UnionFind(map.size());
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (uf.union(map.get(a), map.get(b), values[i])) {
                return true;
            }
        }
        return false;
    }
}

class UnionFind {
    int[] parents;
    double[] values;

    public UnionFind(int n) {
        parents = new int[n];
        values = new double[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            values[i] = 1.0;
        }
    }

    public int find(int x) {
        if (parents[x] != x) {
            int parent = find(parents[x]);
            values[x] *= values[parents[x]];
            parents[x] = parent;
        }
        return parents[x];
    }

    public boolean union(int x, int y, double value) {
        int parentX = find(x);
        int parentY = find(y);
        double valueX = values[x];
        double valueY = values[y];
        if (parentX == parentY) {
            return Math.abs(valueX / valueY - value) >= 1e-5;
        }
        parents[parentY] = parentX;
        values[parentY] = 1 / value * valueX / valueY;
        return false;
    }
}