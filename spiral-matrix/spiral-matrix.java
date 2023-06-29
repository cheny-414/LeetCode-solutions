class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int printed = 1, total = numRows * numCols;
        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);
        matrix[0][0] = -101;
        int direction = 0;
        int[][] directions = new int[4][2];
        directions[0] = new int[]{0, 1};
        directions[1] = new int[]{1, 0};
        directions[2] = new int[]{0, -1};
        directions[3] = new int[]{-1, 0};

        int row = 0, col = 0;
        while (printed < total) {
            int nextRow = row + directions[direction][0];
            int nextCol = col + directions[direction][1];

            if (nextRow < numRows && nextCol < numCols && nextRow >= 0 && nextCol >= 0) {
                if (matrix[nextRow][nextCol] > -101) {
                    result.add(matrix[nextRow][nextCol]);
                    matrix[nextRow][nextCol] = -101;
                    printed++;
                    row = nextRow;
                    col = nextCol;
                } else {
                    direction = (direction + 1) % 4;
                }
            } else {
                direction = (direction + 1) % 4;
            }
        }
        return result;
    }
}