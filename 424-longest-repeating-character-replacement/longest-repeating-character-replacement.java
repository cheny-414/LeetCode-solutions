class Solution {
    public int characterReplacement(String s, int k) {
        // binary search over the length of substring
        // lo contains the valid value, and hi contains the
        // invalid value
        int lo = 1;
        int hi = s.length();
        int answer = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            // can we make a valid substring of length `mid`?
            if (canMakeValidSubstring(s, mid, k)) {
                // explore the right half
                lo = mid + 1;
                answer = mid;
            } else {
                // explore the left half
                hi = mid - 1;
            }
        }

        // length of the longest substring that satisfies
        // the given condition
        return answer;
    }

    private Boolean canMakeValidSubstring(
            String s,
            int substringLength,
            int k) {
        // take a window of length `substringLength` on the given
        // string, and move it from left to right. If this window
        // satisfies the condition of a valid string, then we return
        // true

        int[] freqMap = new int[26];
        int maxFrequency = 0;
        for (int i = 0; i < substringLength; i++) {
            freqMap[s.charAt(i) - 'A']++;
            if (freqMap[s.charAt(i) - 'A'] > maxFrequency) {
                maxFrequency = freqMap[s.charAt(i) - 'A'];
            }
            if (substringLength - maxFrequency <= k) return true;
        }
        int right = substringLength - 1;
        int left = 0;
        for (int i = 0; i < (s.length() - substringLength); i++) {
            freqMap[s.charAt(left) - 'A']--;
            left++;
            right++;
            freqMap[s.charAt(right) - 'A']++;
            if (freqMap[s.charAt(right) - 'A'] > maxFrequency) {
                maxFrequency = freqMap[s.charAt(right) - 'A'];
            }
            if (substringLength - maxFrequency <= k) return true;
        }
        return false;
    }
}