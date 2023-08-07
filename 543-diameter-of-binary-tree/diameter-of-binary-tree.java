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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max; 
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int maxPathLeft = dfs(root.left);
        int maxPathRight = dfs(root.right);
        max = Math.max(max, maxPathLeft + maxPathRight);
        return 1 + Math.max(maxPathLeft, maxPathRight);
    }
}