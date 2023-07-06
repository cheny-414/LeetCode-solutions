/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        Node dummy = new Node(0);
        Node pointer = dummy;
        Node head = root;

        while (head != null) {
            Node node = head;
            while (node != null) {
                if (node.left != null) {
                    pointer.next = node.left;
                    pointer = pointer.next;
                }

                if (node.right != null) {
                    pointer.next = node.right;
                    pointer = pointer.next;
                }

                node = node.next;
            }

            head = dummy.next;
            dummy.next = null;
            pointer = dummy;
        }
        return root;
    }
}