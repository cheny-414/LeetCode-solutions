class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        int[] lps = new int[m];
        if (m > n) return -1;

        int i = 1;
        int prev = 0;
        while (i < m) {
            if (needle.charAt(i) == needle.charAt(prev)) {
                prev++;
                lps[i++] = prev;
            } else {
                if (prev == 0) {
                    lps[i++] = 0;
                } else {
                    prev = lps[prev - 1];
                }
            }
        }

        int needleP = 0;
        int haystackP = 0;

        while (haystackP < n) {
            if (haystack.charAt(haystackP) == needle.charAt(needleP)) {
                haystackP++;
                needleP++;
                if (needleP == m) {
                    return (haystackP - m);
                }
            } else {
                if (needleP == 0) {
                    haystackP++;
                } else {
                    needleP = lps[needleP - 1];
                }
            }
        }
        return -1;
    }
}