class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                res = Math.max(res, right - left + 1);
            } else {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left++));
                }
            }
            set.add(s.charAt(right++));
        }
        return res;
    }
}