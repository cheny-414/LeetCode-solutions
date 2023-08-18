class Solution {
    public int minimumKeypresses(String s) {
        Integer[] freq = new Integer[26];
        Arrays.fill(freq, 0);
        int presses = 0;
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        Arrays.sort(freq, Collections.reverseOrder());
        
        for (int i = 0; i < 9; i++) {
            presses += freq[i];
        }
        for (int i = 9; i < 18; i++) {
            presses += freq[i] * 2;
        }
        for (int i = 18; i < 26; i++) {
            presses += freq[i] * 3;
        }
        return presses;
    }
}