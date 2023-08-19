class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int curr = 0;
        int result = 0;
        int sign = 1; //1 = positive, -1 = negative
        for (char c : s.toCharArray()) {
            char now = c;
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            } else if (c == '+' || c== '-') {
                result += sign * curr;
                sign = c == '+' ? 1 : -1;
                curr = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                curr = 0;
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result += sign * curr;
                result *= stack.pop();
                result += stack.pop();
                curr = 0;
            }
        }
        result += sign * curr;
        return result;
    }
}