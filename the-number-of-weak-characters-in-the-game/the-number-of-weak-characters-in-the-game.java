class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int maxDefense = properties[properties.length - 1][1];
        int weak = 0;

        for (int i = properties.length - 1; i >= 0; i--) {
            if (properties[i][1] < maxDefense) {
                weak++;
            }
            maxDefense = Math.max(maxDefense, properties[i][1]);
        }
        return weak;
    }
}