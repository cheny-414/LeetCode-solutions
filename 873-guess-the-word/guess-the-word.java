/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        Random random = new Random();
        int matches = -1;
        List<String> candidates = Arrays.asList(words);
        while (matches != 6) {
            String guess = candidates.get(random.nextInt(candidates.size()));
            matches = master.guess(guess);
            List<String> newCandidates = new ArrayList<>();
            for (String word : candidates) {
                if (matches == getMatches(guess, word)) {
                    newCandidates.add(word);
                }
            }
            candidates = newCandidates;
        }
    }
    private int getMatches(String word1, String word2) {
        int m = 0;
        for (int i = 0, j = 0; i < 6 && j < 6; ++i, ++j){
            if (word1.charAt(i) == word2.charAt(j)){
                m++;
            }
        }
        return m;
    }
}