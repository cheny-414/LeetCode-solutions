class BrowserHistory {
    Node sHead;
    Node sTail;
    Node curr;
    public BrowserHistory(String homepage) {
        sHead = new Node("-1");
        sTail = new Node("-1");
        Node node = new Node(homepage);
        sHead.next = node;
        node.prev = sHead;
        node.next = sTail;
        sTail.prev = node;
        curr = node;
    }
    
    public void visit(String url) {
        Node node = new Node(url);
        curr.next = node;
        node.prev = curr;
        node.next = sTail;
        sTail.prev = node;
        curr = curr.next;
    }
    
    public String back(int steps) {
        while (steps > 0 && curr.prev != sHead) {
            curr = curr.prev;
            steps--;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while (steps > 0 && curr.next != sTail) {
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }
}

class Node {
    String url;
    Node prev;
    Node next;
    public Node(String url) {
        this.url = url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */