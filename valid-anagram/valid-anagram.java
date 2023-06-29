class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen != tLen) return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < sLen; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < tLen; i++) {
            char key = t.charAt(i);
            if (!map.containsKey(key) || map.get(key) == 0) {
                return false;
            } else {
                map.put(key, map.get(key) - 1);
            }
        }
        return true;
    }
}