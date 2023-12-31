class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int answer = 0;

        for (int t : time) {
            if (t % 60 == 0) {
                answer += remainders[0]++;
            } else {
                answer += remainders[60 - t % 60];
                remainders[t % 60]++;
            }
        }
        return answer;
    }
}