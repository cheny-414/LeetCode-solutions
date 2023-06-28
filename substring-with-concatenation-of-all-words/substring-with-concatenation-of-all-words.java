class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordCount = words.length;
        int wordLen = words[0].length();
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int wordsLeft = wordCount;
            Map<String, Integer> seen = new HashMap<>();

            for (int right = i, left = i; right <= n - wordLen; right += wordLen) {
                String target = s.substring(right, right + wordLen);
                if (!map.containsKey(target)) {
                    seen.clear();
                    wordsLeft = wordCount;
                    left = right + wordLen;
                } else {
                    seen.put(target, seen.getOrDefault(target, 0) + 1);
                    while (seen.get(target) > map.get(target)) {
                        String removeWord = s.substring(left, left + wordLen);
                        seen.put(removeWord, seen.get(removeWord) - 1);
                        left += wordLen;
                        ++wordsLeft;
                    }
                    --wordsLeft;
                }

                if (wordsLeft == 0) {
                    result.add(left);
                }
            }
        }
        return result;
    }
}