class Solution {
    
    List<String> answer = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (List<String> ticket : tickets) {
          if (!targets.containsKey(ticket.get(0))) {
            targets.put(ticket.get(0), new PriorityQueue<>());
          }
          targets.get(ticket.get(0)).add(ticket.get(1));
        }
        visit("JFK", targets);
        Collections.reverse(answer);
        return answer;
    }
    public void visit(String airport, Map<String, PriorityQueue<String>> targets) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
            visit(targets.get(airport).poll(), targets);
        }
        answer.add(airport);
    }
}