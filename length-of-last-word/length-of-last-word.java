class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int answer = 0;
        boolean word = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                word = true;
                answer++;
            }
            else {
                if (word) return answer;
            }
        }
        return answer;
    }
}