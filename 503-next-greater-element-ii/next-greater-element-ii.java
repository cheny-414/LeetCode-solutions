class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                answer[index] = nums[i];
            }
            stack.push(i);
        }

        int i = 0;
        while (!stack.isEmpty() && i < n) {
            if (nums[i] <= nums[stack.peek()]) {
                i++;
            } else {
                answer[stack.pop()] = nums[i];
            }
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}