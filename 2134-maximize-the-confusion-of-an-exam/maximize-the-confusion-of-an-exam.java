class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0;
        int maxSize = 1;
        int countT = 0, countF = 0;

        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == 'T') {
                countT++;
            } else {
                countF++;
            }
            while (Math.min(countT, countF) > k) {
                if (answerKey.charAt(left) == 'T') {
                    countT--;
                } else {
                    countF--;
                }
                left++;
            }
            maxSize = Math.max(maxSize, right - left + 1);
        }
        return maxSize;
    }
}