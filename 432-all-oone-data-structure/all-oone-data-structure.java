class Node {
    int freq;
    Node prev;
    Node next;
    Set<String> keys;

    public Node (int freq) {
        this.freq = freq;
        keys = new HashSet<>();
    }
}

class AllOne {
    private Node head;
    private Node tail;
    Map<String, Node> map;

    public AllOne() {
        head = null;
        tail = null;
        map = new HashMap<>();
    }
    
    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int freq = node.freq;
            node.keys.remove(key);
            if (node.next == null) {
                Node newNode = new Node(freq + 1);
                node.next = newNode;
                newNode.prev = node;
                newNode.keys.add(key);
                map.put(key, newNode);
                tail = newNode;
            } else {
                Node next = node.next;
                if (next.freq - freq > 1) {
                    Node newNode = new Node(freq + 1);
                    node.next = newNode;
                    newNode.prev = node;
                    newNode.next = next;
                    next.prev = newNode;
                    newNode.keys.add(key);
                    map.put(key, newNode);
                } else {
                    next.keys.add(key);
                    map.put(key, next);
                }
            }

            if (node.keys.size() == 0) {
                removeNode(node);
            }

        } else {
            if (head == null) {
                head = new Node(1);
                head.keys.add(key);
                tail = head;
            } else {
                if (head.freq == 1) {
                    head.keys.add(key);
                } else {
                    Node newNode = new Node(1);
                    newNode.keys.add(key);
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                }
            }
            map.put(key, head);
        }
    }
    
    public void dec(String key) {
        if (!map.containsKey(key)) {
            return;
        }
        Node node = map.get(key);
        node.keys.remove(key);
        int freq = node.freq;
        if (freq == 1) {
            map.remove(key);
        } else if (node == head) {
            Node newNode = new Node(freq - 1);
            newNode.keys.add(key);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            map.put(key, head);
        } else {
            Node prev = node.prev;
            if (freq - prev.freq > 1) {
                Node newNode = new Node(freq - 1);
                prev.next = newNode;
                newNode.prev = prev;
                newNode.next = node;
                node.prev = newNode;
                newNode.keys.add(key);
                map.put(key, newNode);
            } else {
                prev.keys.add(key);
                map.put(key, prev);
            }
        }
        if (node.keys.size() == 0) {
            removeNode(node);
        }
    }
    
    public String getMaxKey() {
        if (head == null) {
            return "";
        }
        return tail.keys.iterator().next();
    }
    
    public String getMinKey() {
        if (head == null) {
            return "";
        }
        return head.keys.iterator().next();
    }

    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            this.head = this.head.next;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            this.tail = this.tail.prev;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */