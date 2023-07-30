class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int lowerLimit = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int num : preorder) {
            while (!stack.isEmpty() && stack.peek() < num) {
                lowerLimit = stack.pop();
            }

            if (num <= lowerLimit) {
                return false;
            }
            stack.push(num);
        }
        return true;
    }
}