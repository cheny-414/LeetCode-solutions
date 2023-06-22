class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int n = heights.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
                int currHeight = heights[stack.pop()];
                int currWidth = i - 1 - stack.peek();
                int currArea = currHeight * currWidth;
                if (currArea > maxArea) {
                    maxArea = currArea;
                }
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currHeight = heights[stack.pop()];
            int currWidth = n - 1 - stack.peek();
            int currArea = currHeight * currWidth;
            if (currArea > maxArea) {
                maxArea = currArea;
            }
        }
        return maxArea;
    }
}