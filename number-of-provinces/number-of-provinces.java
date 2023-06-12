class Solution {
    int provinces = 0;
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 1) return 1;
        visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, isConnected);
            }
        }
        return provinces;
    }

    private void dfs(int node, int[][] isConnected) {
        visited[node] = true;
        for (int i = 0; i < isConnected[node].length; i++) {
            if (isConnected[node][i] == 1 && node != i && !visited[i]) {
                dfs(i, isConnected);
            }
        }
    }
}