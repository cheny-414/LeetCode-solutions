class Solution {
    public int minFlips(String target) {
        int count = 0, size = target.length();
        char prev = '0';
        for (int i = 0; i < size; i++) {
            if (target.charAt(i) != prev) {
                count++;
                prev = target.charAt(i);
            }
        }
        return count;
    }
}