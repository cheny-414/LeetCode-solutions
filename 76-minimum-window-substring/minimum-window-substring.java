class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> needMap = new HashMap<>();
        Map<Character, Integer> haveMap = new HashMap<>();
        int m = s.length();
        int n = t.length();
        int minLeft = -1;
        int minRight = -1;
        int minWindow = s.length() + 1;

        //populate need char map
        for (char c : t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        //sliding window
        int left = 0, right = 0;
        int need = needMap.size();
        int have = 0;
        while (right < m) {
            char curr = s.charAt(right);
            if (needMap.containsKey(curr)) {
                haveMap.put(curr, haveMap.getOrDefault(curr, 0) + 1);
                if (haveMap.get(curr).intValue() == needMap.get(curr).intValue()) {
                    have++;
                }
            }
            while (have == need && left <= right) {
                if (right - left + 1 < minWindow) {
                    minWindow = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }
                char release = s.charAt(left);
                if (needMap.containsKey(release))  {
                    haveMap.put(release, haveMap.get(release) - 1);
                    if (haveMap.get(release).intValue() < needMap.get(release).intValue()) {
                        have--;
                    }
                }
                left++;
            }
            right++;
        }
        return minWindow == s.length() + 1 ? "" : s.substring(minLeft, minRight + 1);
    }
}