class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> map = new HashMap<>();
        long day = 0;

        for (int task : tasks) {
            if (map.containsKey(task) && day < map.get(task)) {
                day = map.get(task);
            } else {
                day++;
            }
            map.put(task, day + space + 1);
        }
        return day;
    }
}