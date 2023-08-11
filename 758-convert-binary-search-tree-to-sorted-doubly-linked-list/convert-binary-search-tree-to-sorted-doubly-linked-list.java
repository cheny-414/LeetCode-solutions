/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node first = null;
        Node last = null;
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node node = stack.pop();
                
                //the linking part, everything else same as normal inorder traversal
                if (first == null) {
                    first = node;
                }
                if (last != null) {
                    last.right = node;
                    node.left = last;
                }
                last = node;
                //

                curr = node.right;
            }
        }
        first.left = last;
        last.right = first;
        return first;
    }
}