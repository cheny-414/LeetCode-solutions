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

        Interval curr = q.poll();
        while (!q.isEmpty()) {
            if (curr.end < q.peek().start) {
                answer.add(new Interval(curr.end, q.peek().start));
                curr = q.poll();
            } else {
                curr = curr.end < q.peek().end ? q.peek() : curr;
                q.poll();
            }
        }
        return answer;
    }
}