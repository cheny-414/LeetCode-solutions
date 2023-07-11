class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new int[] {entry.getKey(), entry.getValue()});
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            var curr = pq.poll();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != (char)curr[0]) {
                sb.append((char)curr[0]);
                if (--curr[1] > 0) {
                    pq.add(curr);
                }
            } else {
                if (pq.isEmpty()) {
                    return "";
                }
                var backup = pq.poll();
                sb.append((char) backup[0]);
                if (--backup[1] > 0) {
                    pq.offer(backup);
                }
                pq.offer(curr);
            }
        }
        return sb.toString();
    }
}