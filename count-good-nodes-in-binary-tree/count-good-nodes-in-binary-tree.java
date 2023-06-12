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
    private int goodNodes = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);

        return goodNodes;
    }

    private void dfs(TreeNode root, int max) {
        if (root != null) {
            if (max <= root.val) {
                goodNodes++;
            }
            dfs(root.left, Math.max(root.val, max));
            dfs(root.right, Math.max(root.val, max));
        }
    }
}