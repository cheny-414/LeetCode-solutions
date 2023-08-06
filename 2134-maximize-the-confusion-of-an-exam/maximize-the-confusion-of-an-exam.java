class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0;
        int maxSize = 1;
        int countT = 0, countF = 0;
        if (answerKey.charAt(0) == 'T') {
            countT++;
        } else {
            countF++;
        }

        for (int right = 1; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') {
                countT++;
            } else {
                countF++;
            }
            if (Math.min(countT, countF) <= k) {
                maxSize = Math.max(maxSize, right - left + 1);
            } else {
                while (Math.min(countT, countF) > k) {
                    if (answerKey.charAt(left) == 'T') {
                        countT--;
                    } else {
                        countF--;
                    }
                    left++;
                }
            }
        }
        return maxSize;
    }
}