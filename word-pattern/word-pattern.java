class Solution {
    String s;
    public boolean wordPattern(String pattern, String s) {
        this.s = s;
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            String word = getWord();
            char key = pattern.charAt(i);
            if (word.length() == 0) return false;
            if (!map.containsKey(key)) {
                if (!set.contains(word)) {
                    map.put(key, word);
                    set.add(word);
                } else {
                    return false;
                }
            } else {
                if (!map.get(key).equals(word)) {
                    String gotten = map.get(key);
                    return false;
                }
            }
        }
        int length = this.s.length();
        return this.s.length() == 0 ? true : false;
    }

    private String getWord() {
        if (s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) == ' ') {
                this.s = s.substring(i + 1, s.length());
                return sb.toString();
            }
        }
        this.s = "";
        return sb.toString();
    }
}