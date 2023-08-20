class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area_a = (ax2 - ax1) * (ay2 - ay1);
        int area_b = (bx2 - bx1) * (by2 - by1);

        //check for total overlap
        if (ax2 >= bx2 && ax1 <= bx1 && ay2 >= by2 && ay1 <= by1) {
            return area_a;
        }

        if (bx2 >= ax2 && bx1 <= ax1 && by2 >= ay2 && by1 <= ay1) {
            return area_b;
        }

        //height overlap:
        int heightOverlap = 0;
        if (ay1 <= by1 && ay2 >= by2) {
            heightOverlap = by2 - by1;
        } else if (by1 <= ay1 && by2 >= ay2) {
            heightOverlap = ay2 - ay1;
        } else if (ay1 >= by1) {
            heightOverlap = Math.max(0, by2 - ay1);
        } else {
            heightOverlap = Math.max(0, ay2 - by1);
        }

        //width overlap:
        int widthOverlap = 0;
        if (ax1 <= bx1 && ax2 >= bx2) {
            widthOverlap = bx2 - bx1;
        } else if (bx1 <= ax1 && bx2 >= ax2) {
            widthOverlap = ax2 - ax1;
        } else if (ax1 >= bx1) {
            widthOverlap = Math.max(0, bx2 - ax1);
        } else {
            widthOverlap = Math.max(0, ax2 - bx1);
        }

        return area_a + area_b - (heightOverlap * widthOverlap);
    }
}