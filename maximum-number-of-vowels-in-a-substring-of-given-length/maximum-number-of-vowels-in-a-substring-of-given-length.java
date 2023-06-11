class Solution {
    ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    public int maxVowels(String s, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += vowels.contains(s.charAt(i)) ? 1 : 0;
        }
        int max = sum;
        for (int i = 1; i < s.length() - k + 1; i++) {
            sum = sum - (vowels.contains(s.charAt(i - 1)) ? 1 : 0) + (vowels.contains(s.charAt(i - 1 + k)) ? 1 : 0);
            max = Math.max(sum, max);
        }
        return max;
    }
}