class Solution {
    Map<String, PriorityQueue<String>> targets;
    List<String> answer = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        targets = new HashMap<>();
        for (List<String> ticket : tickets) {
          targets.putIfAbsent(ticket.get(0), new PriorityQueue<>());
          targets.get(ticket.get(0)).add(ticket.get(1));
        }
        visit("JFK");
        return answer;
    }
    public void visit(String airport) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
            visit(targets.get(airport).poll());
        }
        answer.add(0, airport);
    }
}