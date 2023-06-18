class Solution {
    List<String> list = new ArrayList<>();
    int max;
    public List<String> generateParenthesis(int n) {
        max = n;
        backTrack("", 0, 0);
        return list;
    }

    private void backTrack(String str, int open, int close) {
        if (str.length() == 2 * max) {
            list.add(str);
            return;
        }
        if (open < max) {
            backTrack(str+"(", open + 1, close);
        }
        if (close < open) {
            backTrack(str+")", open, close + 1);
        }
    }
}