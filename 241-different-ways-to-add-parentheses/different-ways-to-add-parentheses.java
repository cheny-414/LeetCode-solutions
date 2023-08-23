class Solution {
    Map<String, List<Integer>> dp = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> results = new ArrayList<>();
        //base case
        if (expression.length() <= 2 && Integer.valueOf(expression) >= 0 && Integer.valueOf(expression) <= 99) {
            results.add(Integer.valueOf(expression));
            return results;
        }

        //check dp
        if (dp.containsKey(expression)) return dp.get(expression);

        //recursion
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1, expression.length());
                List<Integer> leftWays = diffWaysToCompute(left);
                List<Integer> rightWays = diffWaysToCompute(right);
                for (int leftWay : leftWays) {
                    for (int rightWay : rightWays) {
                        if (c == '+') {
                            results.add(leftWay + rightWay);
                        } else if (c == '*') {
                            results.add(leftWay * rightWay);
                        } else {
                            results.add(leftWay - rightWay);
                        }
                    }
                }
            }
        }
        return results;
    }
}