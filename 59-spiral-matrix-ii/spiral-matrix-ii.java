class Solution {
    int dir;
    int[][] matrix;
    int n;
    public int[][] generateMatrix(int n) {
        matrix = new int[n][n];
        this.n = n;
        //int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        matrix[0][0] = 1;
        int currRow = 0, currCol = 0;
        dir = 0; //0 = right, 1 = down; 2 = left; 3 = up
        for (int i = 1; i < n * n; i++) {
            int[] next = getNext(currRow, currCol);
            matrix[next[0]][next[1]] = i + 1;
            currRow = next[0];
            currCol = next[1];
        }
        return matrix;
    }

    private int[] getNext(int currRow, int currCol) {
        if (dir == 0) {
            if (currCol + 1 >= n || matrix[currRow][currCol + 1] != 0) {
                dir++;
                return getNext(currRow, currCol);
            } else {
                return new int[] {currRow, currCol + 1};
            }
        } else if (dir == 1) {
            if (currRow + 1 >= n || matrix[currRow + 1][currCol] != 0) {
                dir++;
                return getNext(currRow, currCol);
            } else {
                return new int[] {currRow + 1, currCol};
            }
        } else if (dir == 2) {
            if (currCol - 1 < 0 || matrix[currRow][currCol - 1] != 0) {
                dir++;
                return getNext(currRow, currCol);
            } else {
                return new int[] {currRow, currCol - 1};
            }
        } else {
            if (currRow - 1 < 0 || matrix[currRow - 1][currCol] != 0) {
                dir = 0;
                return getNext(currRow, currCol);
            } else {
                return new int[] {currRow - 1, currCol};
            }
        }
    }
}