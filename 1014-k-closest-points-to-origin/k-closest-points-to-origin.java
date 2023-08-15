class Solution {
    public int[][] kClosest(int[][] points, int k) {
        k = points.length - k;
        quickSelect(0, points.length - 1, points, k);
        return Arrays.copyOfRange(points, k, points.length);
    }

    private void quickSelect(int left, int right, int[][] points, int k) {
        int pointer = left;
        int pivot = distance(points[right]);
        for (int i = left; i < right; i++) {
            int dis = distance(points[i]);
            if (distance(points[i]) >= pivot) {
                swap(i, pointer, points);
                pointer++;
            }
        }
        swap(pointer, right, points);
        if (pointer > k) {
            quickSelect(left, pointer - 1, points, k);
        } else if (pointer < k) {
            quickSelect(pointer + 1, right, points, k);
        }
        //return true;
    }

    private void swap(int i, int j, int[][] points) {
        int temp0 = points[i][0];
        int temp1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = temp0;
        points[j][1] = temp1;
    }

    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}