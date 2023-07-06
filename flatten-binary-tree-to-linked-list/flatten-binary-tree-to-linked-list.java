/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Deque<TreeNode> q;
    public void flatten(TreeNode root) {
        q = new ArrayDeque<>();
        dfs(root);
        TreeNode node = q.poll();
        while (!q.isEmpty()) {
            node.left = null;
            node.right = q.poll();
            node = node.right;
        }
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        q.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}