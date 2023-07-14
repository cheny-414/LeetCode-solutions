class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

        q.add(0);
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int currIndex = q.poll();
                if (visited.contains(currIndex)) continue;
                visited.add(currIndex);
                if (currIndex == arr.length - 1) return steps;
                //add left
                if (currIndex - 1 >= 0) {
                    q.add(currIndex - 1);
                }
                if (currIndex + 1 < arr.length) {
                    q.add(currIndex + 1);
                }
                for (int index : map.getOrDefault(arr[currIndex], new ArrayList<>())) {
                    if (index != currIndex) q.add(index);
                }
                map.remove(arr[currIndex]);
            }
            steps++;
        }
        return steps;
    }
}