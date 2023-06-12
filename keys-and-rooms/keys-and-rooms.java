class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        
        while (!q.isEmpty()) {
            int visit = q.poll();
            visited[visit] = true;
            for(int i = 0; i < rooms.get(visit).size(); i++) {
                if (!visited[rooms.get(visit).get(i)]) {
                    q.offer(rooms.get(visit).get(i));
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }
}