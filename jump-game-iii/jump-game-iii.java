class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int currPos = q.poll();
            if (visited.contains(currPos)) continue;
            visited.add(currPos);
            if (arr[currPos] == 0) return true;
            if (currPos + arr[currPos] < arr.length) {
                q.offer(currPos + arr[currPos]);
            }
            if (currPos - arr[currPos] >= 0) {
                q.offer(currPos - arr[currPos]);
            }
        }
        return false;
    }
}