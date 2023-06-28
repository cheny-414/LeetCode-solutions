class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> wMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        int required = map.size();
        int formed = 0;
        int minWindow = Integer.MAX_VALUE;
        int minLeft = Integer.MAX_VALUE, minRight = Integer.MAX_VALUE;
        while (right < m) {
            char cht = s.charAt(right);
            wMap.put(cht, wMap.getOrDefault(cht, 0) + 1);
            if (map.containsKey(cht) && wMap.get(cht).intValue() == map.get(cht).intValue()) {
                formed++;
            }
            while (formed == required && left <= right) {
                int window = right - left + 1;
                if (window < minWindow) {
                    minWindow = window;
                    minLeft = left;
                    minRight = right;
                }
                char release = s.charAt(left);
                wMap.put(release, wMap.getOrDefault(release, 0) - 1);
                if (map.containsKey(release) && wMap.get(release).intValue() < map.get(release).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        if (minWindow < Integer.MAX_VALUE) {
            return s.substring(minLeft, minRight + 1);
        } else {
            return "";
        }
    }
}