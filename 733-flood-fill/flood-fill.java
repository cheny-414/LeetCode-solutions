class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int sourceColor = image[sr][sc];
        if (sourceColor == color) return image;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            image[curr[0]][curr[1]] = color;
            for (int[] dir : directions) {
                int nexti = curr[0] + dir[0];
                int nextj = curr[1] + dir[1];
                if (nexti >= 0 && nexti < image.length && nextj >= 0 && nextj < image[0].length && image[nexti][nextj] == sourceColor) {
                    queue.add(new int[]{nexti, nextj});
                }
            }
        }
        return image;
    }
}