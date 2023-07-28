class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int pushedP = 0;
        int poppedP = 0;
        while (pushedP < n) {
            if (stack.isEmpty() || stack.peek() != popped[poppedP]) {
                stack.push(pushed[pushedP]);
                pushedP++;
            } else {
                stack.pop();
                poppedP++;
            }
        }
        while (poppedP < n) {
            if (stack.pop() != popped[poppedP++]) {
                return false;
            }
        }
        return true;
    }
}