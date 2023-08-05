class Solution {
    Map<Integer, Integer> indegrees = new HashMap<>();
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int nodeWith2Indegree = -1;
        for (int[] edge : edges) {
            indegrees.put(edge[1], indegrees.getOrDefault(edge[1], 0) + 1);
            if (indegrees.get(edge[1]) == 2) nodeWith2Indegree = edge[1];
        }

        if (nodeWith2Indegree == -1) {
            return buildUF(edges, -1);
        } else {
            for (int i = edges.length - 1; i >= 0; i--) {
                if (edges[i][1] == nodeWith2Indegree) {
                    int[] res = buildUF(edges, i);
                    if(res == null) return edges[i];
                }
            }
        }

        return null;
    }

    public int[] buildUF(int[][] a, int skip){
        UnionFind uf = new UnionFind();
        
        for(int i=0;i<a.length;i++){
            if(i==skip) continue;
            if(!uf.union(a[i][0], a[i][1])) return a[i];
        } 
        
        return null;
    }
}

class UnionFind {
    Map<Integer, Integer> map = new HashMap<>();

    int find(int x){
        if(!map.containsKey(x)) map.put(x, x);

        if(map.get(x)==x) return x;
        int par = find(map.get(x));
        map.put(x, par);
        return par;
    }

    boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px==py) return false;
        map.put(px, py);
        return true;
    }        
}