class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        Set<Character> op = new HashSet<>(Arrays.asList('+', '-', '*', '/'));
        int curr = 0;
        int result;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            } else if (op.contains(c)) {
                nums.push(curr);
                curr = 0;
                while (!ops.isEmpty() && compare(ops.peek(), c)) {
                    int val = evaluate(ops.pop(), nums.pop(), nums.pop());
                    nums.push(val);
                }
                ops.push(c);
            }
        }
        nums.push(curr);
        while (!ops.isEmpty()) {
            int val = evaluate(ops.pop(), nums.pop(), nums.pop());
            nums.push(val);
        }
        return nums.peek();
    }

    private boolean compare(Character a, Character b) {
        int aVal = (a == '+' || a == '-') ? 1 : 2;
        int bVal = (b == '+' || b == '-') ? 1 : 2;
        return aVal >= bVal;
    }

    private int evaluate(Character op, int b, int a) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else if (op == '*') return a * b;
        else return a / b;
    }
}