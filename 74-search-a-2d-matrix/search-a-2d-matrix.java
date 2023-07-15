class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right  = matrix.length * matrix[0].length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / 4;
            int numAtMid = matrix[mid / matrix[0].length][mid % matrix[0].length];
            if (numAtMid == target) return true;
            else if (numAtMid > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}