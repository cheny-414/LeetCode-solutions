/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node tail = null;
    public Node flatten(Node head) {
        if (head == null) return tail;
        tail = flatten(head.next);
        head.next = flatten(head.child);
        if (head.next != null) {
            head.next.prev = head;
        }
        head.child = null;
        return head;
    }
}