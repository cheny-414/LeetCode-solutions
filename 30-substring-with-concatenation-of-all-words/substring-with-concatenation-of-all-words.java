class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int wordLength = words[0].length();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }


        for (int i = 0; i < wordLength; i++) {
            for (String key : map2.keySet()) {
                map.put(key, map2.get(key));
            }
            int left = i;
            int right = i + wordLength;
            while (right <= s.length()) {
                String wordCheck = s.substring(right - wordLength, right);
                if (map.containsKey(wordCheck)) {
                    if (map.get(wordCheck) > 0) {
                        map.put(wordCheck, map.get(wordCheck) - 1);
                        if (right - left == wordLength * words.length) {
                            if (!answer.contains(left)) {
                                answer.add(left);
                            }
                            String wordRelease = s.substring(left, left + wordLength);
                            map.put(wordRelease, map.get(wordRelease) + 1);
                            left += wordLength;
                        }
                    } else {
                        while (map.get(wordCheck) == 0) {
                            String wordRelease = s.substring(left, left + wordLength);
                            map.put(wordRelease, map.get(wordRelease) + 1);
                            left += wordLength;
                        }
                        map.put(wordCheck, map.get(wordCheck) - 1);
                    }
                } else {
                    while (left < right - wordLength) {
                        String wordRelease = s.substring(left, left + wordLength);
                        map.put(wordRelease, map.get(wordRelease) + 1);
                        left += wordLength;
                    }
                    left = right;
                }
                right += wordLength;
            }
        }
        return answer;
    }
}