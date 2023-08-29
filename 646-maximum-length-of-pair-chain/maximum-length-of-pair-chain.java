class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int last = 0;
        int count = 0;
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0 || pairs[i][0] > pairs[last][1]) {
                count++;
                last = i;
            }
        }
        return count;
    }
}