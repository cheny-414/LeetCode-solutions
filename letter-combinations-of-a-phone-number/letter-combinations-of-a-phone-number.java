class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> answer = new LinkedList<String>();
        if (digits.isEmpty()) return answer;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        answer.add("");

        while(answer.peek().length() < digits.length()) {
            String stringToProcess = answer.remove();
            String map = mapping[digits.charAt(stringToProcess.length()) - '0'];
            for (char c : map.toCharArray()) {
                answer.add(stringToProcess + c);
            }
        }
        return answer;
    }
}