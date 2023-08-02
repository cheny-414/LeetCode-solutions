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
        Node leftmost = root;
        if (leftmost == null) return root;
        while (leftmost.left != null) {
            Node node = leftmost;
            while (node != null) {
                node.left.next = node.right;
                node.right.next = node.next == null ? null : node.next.left;
                node = node.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}