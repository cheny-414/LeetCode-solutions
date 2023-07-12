class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Map<Integer, ListNode> map;
    int capacity;
    ListNode sHead;
    ListNode sTail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        sHead = new ListNode(-1, -1);
        sTail = new ListNode(-1, -1);
        sHead.next = sTail;
        sTail.prev = sHead;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        int result = node.val;
        remove(node);
        add(node);
        return result;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            remove(node);
        }
        ListNode newNode = new ListNode(key, value);
        add(newNode);
        map.put(newNode.key, newNode);

        if (map.size() > capacity) {
            ListNode nodeToEvict = sHead.next;
            remove(nodeToEvict);
            map.remove(nodeToEvict.key);
        }
    }

    private void remove(ListNode node) {
        //map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(ListNode node) {
        //map.put(node.key, node);
        sTail.prev.next = node;
        node.prev = sTail.prev;
        node.next = sTail;
        sTail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */