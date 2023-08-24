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
    public Node flatten(Node head) {
        helper(head);
        return head;
    }

    public Node helper(Node head) {
        if (head == null) return null;
        Node curr = head;
        Node tail = null;
        while (curr != null) {
            if (curr.child != null) {
                Node childTail = helper(curr.child);
                if (curr.next != null) {
                    curr.next.prev = childTail;
                    childTail.next = curr.next;
                }
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
            }
            tail = curr;
            curr = curr.next;
        }
        return tail;
    }
}