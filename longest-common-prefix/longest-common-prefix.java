class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minString = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            minString = Math.min(minString, s.length());
        }

        if (minString == 0) return "";
       
        for (int i = 0; i < minString; i++) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (s.charAt(i) != c) return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}