class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> result = new LinkedList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        int n = people.length;
        return result.toArray(new int[n][2]);
    }
}