class AutocompleteSystem {
    Node root;
    Node currNode;
    Node dead;
    StringBuilder currSentence;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Node();
        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }

        currSentence = new StringBuilder();
        currNode = root;
        dead = new Node();
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            addSentence(currSentence.toString(), 1);
            currSentence.setLength(0);
            currNode = root;
            return new ArrayList<String>();
        }

        currSentence.append(c);
        if (!currNode.children.containsKey(c)) {
            currNode = dead;
            return new ArrayList<String>();
        }
        currNode = currNode.children.get(c);
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
            int hotA = currNode.sentences.get(a);
            int hotB = currNode.sentences.get(b);
            if (hotA == hotB) {
                return b.compareTo(a);
            }
            return hotA - hotB;
        });
        
        for (String sentence: currNode.sentences.keySet()) {
            heap.add(sentence);
            if (heap.size() > 3) {
                heap.remove();
            }
        }
        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            ans.add(heap.remove());
        }
        
        Collections.reverse(ans);
        return ans;
    }

    public void addSentence(String sentence, int count) {
        Node node = root;
        for (char c : sentence.toCharArray()) {
            node.children.putIfAbsent(c, new Node());
            node = node.children.get(c);
            node.sentences.put(sentence, node.sentences.getOrDefault(sentence, 0) + count);
        }
    }
}

class Node {
    Map<Character, Node> children;
    Map<String, Integer> sentences;
    public Node() {
        children = new HashMap<>();
        sentences = new HashMap<>();
    }
}
/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */