class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().getValue() > heights[i]) {
                Pair<Integer, Integer> popped = stack.pop();
                int poppedIndex = popped.getKey();
                int poppedHeight = popped.getValue();
                maxArea = Math.max(maxArea, poppedHeight * (i - poppedIndex));
                start = poppedIndex;
            }
            stack.push(new Pair<>(start, heights[i]));
        }

        while (!stack.isEmpty()) {
            Pair<Integer, Integer> popped = stack.pop();
            int poppedIndex = popped.getKey();
            int poppedHeight = popped.getValue();
            maxArea = Math.max(maxArea, poppedHeight * (heights.length - poppedIndex));
        }
        return maxArea;
    }
}