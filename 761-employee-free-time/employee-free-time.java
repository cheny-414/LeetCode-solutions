/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> q = new PriorityQueue<>((a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
        List<Interval> answer = new ArrayList<>();
        for (int i = 0; i < schedule.size(); i++) {
            for (int j = 0; j < schedule.get(i).size(); j++) {
                q.add(schedule.get(i).get(j));
            }
        }

        int currEnd = q.poll().end;
        while (!q.isEmpty()) {
            if (currEnd < q.peek().start) {
                answer.add(new Interval(currEnd, q.peek().start));
                currEnd = q.poll().end;
            } else {
                currEnd = Math.max(currEnd, q.peek().end);
                q.poll();
            }
        }
        return answer;
    }
}