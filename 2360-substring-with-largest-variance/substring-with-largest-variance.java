class Solution {
    public int largestVariance(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            counter[index]++;
        }

        int globalMax = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j || counter[i] == 0 || counter[j] == 0) {
                    continue;
                }
                char A = (char)('a' + i); //MORE
                char B = (char)('a' + j); //LESS
                int countA = 0, countB = 0;
                int remainA = counter[i], remainB = counter[j];
                for (int k = 0; k < s.length(); k++) {
                    if (s.charAt(k) == A) {
                        countA++;
                    }
                    if (s.charAt(k) == B) {
                        countB++;
                        remainB--;
                    }
                    if (countB > 0) {
                        globalMax = Math.max(globalMax, countA - countB);
                    }
                    if (countA < countB && remainB > 0) {
                        countA = 0;
                        countB = 0;
                    }
                }
            }
        }
        return globalMax;
    }
}