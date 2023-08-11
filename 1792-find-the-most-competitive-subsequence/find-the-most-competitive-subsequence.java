class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[k];
        int remaining = n - k;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i] && remaining > 0) {
                stack.pop();
                remaining--;
            }
            stack.push(i);
        }

        //could be more than k on the stack
        while (remaining > 0) {
            stack.pop();
            remaining--;
        }

        for (int i = k - 1; i >= 0; i--) {
            res[i] = nums[stack.pop()];
        }

        return res;
    }
}