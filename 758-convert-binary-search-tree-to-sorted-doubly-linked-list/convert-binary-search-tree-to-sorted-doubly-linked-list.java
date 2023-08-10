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
    List<Node> list;
    public Node treeToDoublyList(Node root) {
        list = new ArrayList<>();
        if (root == null) return null;
        dfs(root);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).left = i == 0 ? list.get(list.size() - 1) : list.get(i - 1);
            list.get(i).right = i == list.size() - 1 ? list.get(0) : list.get(i + 1);
        }
        return list.get(0);
    }

    private void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root);
        dfs(root.right);
    }
}