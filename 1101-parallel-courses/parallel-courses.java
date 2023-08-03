class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Deque<Integer> q = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[n + 1];
        int coursesTaken = 0;
        int semesters = 0;

        for (int[] relation : relations) {
            int prev = relation[0];
            int next = relation[1];
            if (!map.containsKey(prev)) {
                map.put(prev, new ArrayList<>());
            }
            map.get(prev).add(next);
            indegrees[next]++;
        }

        for (int i  = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int course = q.pop();
                coursesTaken++;
                if (!map.containsKey(course)) continue;
                for (int nextCourse : map.get(course)) {
                    indegrees[nextCourse]--;
                    if (indegrees[nextCourse] == 0) {
                        q.add(nextCourse);
                    }
                }
            }
            semesters++;
        }
        return coursesTaken == n ? semesters : -1;
    }
}