class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> word1Counts = countChars(word1);
        HashMap<Character, Integer> word2Counts = countChars(word2);

        if (!word1Counts.keySet().equals(word2Counts.keySet())) {
            return false;
        }
        List<Integer> word1FrequencyList = new ArrayList<>(word1Counts.values());
        List<Integer> word2FrequencyList = new ArrayList<>(word2Counts.values());
        Collections.sort(word1FrequencyList);
        Collections.sort(word2FrequencyList);
        return word1FrequencyList.equals(word2FrequencyList);

    }

    private HashMap<Character, Integer> countChars(String word) {
        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            charCounts.put(word.charAt(i), charCounts.getOrDefault(word.charAt(i), 0) + 1);
        }
        return charCounts;
    }
}