class Solution {
    int[][] grid;
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int m;
    int n;
    Map<Integer, Integer> colorToSize;
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        colorToSize =  new HashMap<>();
        int color = 2;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = paint(i, j, color);
                    colorToSize.put(color, area);
                    color++;
                }
            }
        }
        int answer = 0;
        for (int thisColor : colorToSize.keySet()) {
            answer = Math.max(colorToSize.get(thisColor), answer);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighborColors = new HashSet<>();
                    for (int[] direction : directions) {
                        int nexti = i + direction[0];
                        int nextj = j + direction[1];
                        if (nexti < grid.length && nextj < grid[0].length && nexti >= 0 && nextj >= 0 && grid[nexti][nextj] != 0) {
                            neighborColors.add(grid[nexti][nextj]);
                        }
                    }
                    int sizeFormed = 1;
                    for (int neighborColor : neighborColors) {
                        sizeFormed += colorToSize.get(neighborColor);
                    }
                    answer = Math.max(sizeFormed, answer);
                }
            }
        }
        return answer;
    }

    private int paint(int row, int col, int color) {
        grid[row][col] = color;
        int area = 1;

        for (int[] direction : directions) {
            int nexti = row + direction[0];
            int nextj = col + direction[1];
            if (nexti < grid.length && nextj < grid[0].length && nexti >= 0 && nextj >= 0 && grid[nexti][nextj] == 1) {
                area += paint(nexti, nextj, color);
            }
        }
        return area;
    }
}