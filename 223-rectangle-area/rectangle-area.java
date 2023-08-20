class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area_a = (ax2 - ax1) * (ay2 - ay1);
        int area_b = (bx2 - bx1) * (by2 - by1);

        //height overlap:
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);

        //width overlap:
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);

        int overlapArea = 0;
        if (top - bottom > 0 && right - left > 0) {
            overlapArea = (top - bottom) * (right - left);
        }

        return area_a + area_b - overlapArea;
    }
}